package at.topc.tado.client

import at.topc.tado.config.TadoConfig
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.datetime.Clock
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import mu.KLogging
import org.apache.http.HttpHeaders
import org.apache.http.HttpResponse
import org.apache.http.HttpStatus
import org.apache.http.client.config.CookieSpecs
import org.apache.http.client.config.RequestConfig
import org.apache.http.client.entity.UrlEncodedFormEntity
import org.apache.http.client.methods.HttpDelete
import org.apache.http.client.methods.HttpGet
import org.apache.http.client.methods.HttpPost
import org.apache.http.client.methods.HttpPut
import org.apache.http.entity.ContentType
import org.apache.http.entity.StringEntity
import org.apache.http.impl.nio.client.HttpAsyncClients
import org.apache.http.message.BasicNameValuePair
import org.apache.http.util.EntityUtils
import java.io.Closeable
import java.nio.charset.StandardCharsets
import kotlin.time.Duration.Companion.seconds

class TadoClient(private val config: TadoConfig) : Closeable {
    private val client = HttpAsyncClients.custom().apply {
        setDefaultRequestConfig(
            RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD).build()
        )
    }.build().apply { start() }

    private val tokenMutex = Mutex()
    private var tokens: TadoTokens? = null
    private val renewBeforeExpiryDuration = config.renewBeforeExpiry.seconds

    private suspend fun tokenRequest(vararg formData: BasicNameValuePair) {
        val httpPost = HttpPost("$TADO_AUTH/oauth/token")
        httpPost.entity = UrlEncodedFormEntity(
            listOf(
                BasicNameValuePair("client_id", config.oauthCreds.clientId),
                BasicNameValuePair("client_secret", config.oauthCreds.clientSecret),
                BasicNameValuePair("scope", "home.user")
            ).plus(formData)
        )

        val response = client.execute(httpPost)
        logger.debug { "Token response ${response.statusLine.statusCode}" }
        val jsonResponse = EntityUtils.toString(response.entity, StandardCharsets.UTF_8)
        tokens = TadoTokens(json.decodeFromString<TokenResponse>(jsonResponse))
        logger.debug { "New token ${tokens?.expiry}" }
    }

    private suspend fun getToken() =
        tokenRequest(
            BasicNameValuePair("grant_type", "password"),
            BasicNameValuePair("username", config.email),
            BasicNameValuePair("password", config.password)
        )

    private suspend fun refreshToken() =
        tokenRequest(
            BasicNameValuePair("grant_type", "refresh_token"),
            BasicNameValuePair("refresh_token", tokens?.refreshToken)
        )

    private suspend fun tokenForGet(): String {
        tokenMutex.withLock {
            tokens.let { t ->
                if (t == null) {
                    logger.debug { "Getting token with login" }
                    getToken()
                } else if (t.expiry < Clock.System.now().plus(renewBeforeExpiryDuration)) {
                    logger.debug { "Refreshing token" }
                    refreshToken()
                }
            }
        }

        return tokens!!.accessToken
    }

    suspend fun <T> get(s: KSerializer<T>, url: String): T {
        logger.debug { "GET $url" }
        return try {
            HttpGet(url)
                .apply {
                    addHeader(HttpHeaders.AUTHORIZATION, "Bearer ${tokenForGet()}")
                }
                .let { httpGet -> client.execute(httpGet) }
                .let { response -> parseResponse(s, null, response) }
        } catch (e: Exception) {
            logger.error(e) { "Error during GET $url" }
            throw e
        }
    }

    suspend fun <T, U> post(bs: KSerializer<T>, s: KSerializer<U>, url: String, body: T): U {
        logger.debug { "POST $url" }
        return try {
            HttpPost(url)
                .apply {
                    addHeader(HttpHeaders.AUTHORIZATION, "Bearer ${tokenForGet()}")
                    entity = StringEntity(json.encodeToString(bs, body), ContentType.APPLICATION_JSON)
                }
                .let { httpPut -> client.execute(httpPut) }
                .let { response -> parseResponse(s, body, response) }
        } catch (e: Exception) {
            logger.error(e) { "Error during POST $url" }
            throw e
        }
    }

    suspend fun <T, U> put(bs: KSerializer<T>, s: KSerializer<U>, url: String, body: T): U {
        logger.debug { "PUT $url" }
        return try {
            HttpPut(url)
                .apply {
                    addHeader(HttpHeaders.AUTHORIZATION, "Bearer ${tokenForGet()}")
                    entity = StringEntity(json.encodeToString(bs, body), ContentType.APPLICATION_JSON)
                }
                .let { httpPut -> client.execute(httpPut) }
                .let { response -> parseResponse(s, body, response) }
        } catch (e: Exception) {
            logger.error(e) { "Error during PUT $url" }
            throw e
        }
    }

    suspend fun delete(url: String) {
        logger.debug { "DELETE $url" }
        try {
            HttpDelete(url)
                .apply {
                    addHeader(HttpHeaders.AUTHORIZATION, "Bearer ${tokenForGet()}")
                }
                .let { httpPut -> client.execute(httpPut) }
        } catch (e: Exception) {
            logger.error(e) { "Error during DELETE $url" }
            throw e
        }
    }

    private fun <T, U> parseResponse(s: KSerializer<U>, body: T, res: HttpResponse): U {
        val text = EntityUtils.toString(res.entity, StandardCharsets.UTF_8)
        val code = res.statusLine.statusCode

        logger.debug { "Response $code - $text" }

        return if (code != HttpStatus.SC_OK) {
            throw TadoRequestException(text, code, body)
        } else {
            try {
                json.decodeFromString(s, text)
            } catch (e: SerializationException) {
                throw TadoJsonException(text, body, e)
            }
        }
    }

    override fun close() {
        client.close()
    }

    companion object : KLogging() {
        const val TADO_API = "https://my.tado.com/api/v2"
        const val TADO_AUTH = "https://auth.tado.com"

        internal val json = Json {
            prettyPrint = true
        }
    }
}
