package at.topc.tado.client

import at.topc.tado.config.TadoConfig
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.datetime.Clock
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.Json.Default.serializersModule
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.serializer
import org.apache.http.HttpHeaders
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

class TadoClient(private val config: TadoConfig) : Closeable {
    private val client = HttpAsyncClients.custom().apply {
        setDefaultRequestConfig(
            RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD).build()
        )
    }.build().apply { start() }

    private val tokenMutex = Mutex()
    private var tokens: TadoTokens? = null

    private suspend fun tokenRequest(vararg formData: BasicNameValuePair) {
        println("tokenRequest ${formData.size}")

        val httpPost = HttpPost("$TADO_AUTH/oauth/token")
        httpPost.entity = UrlEncodedFormEntity(
            listOf(
                BasicNameValuePair("client_id", config.oauthCreds.clientId),
                BasicNameValuePair("client_secret", config.oauthCreds.clientSecret),
                BasicNameValuePair("scope", "home.user")
            ).plus(formData)
        )

        val response = client.execute(httpPost)
        val jsonResponse = EntityUtils.toString(response.entity, StandardCharsets.UTF_8)
        tokens = TadoTokens(json.decodeFromString<TokenResponse>(jsonResponse))
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
                    getToken()
                } else if (t.expiry < Clock.System.now()) {
                    refreshToken()
                }
            }
        }

        return tokens!!.accessToken
    }

    suspend inline fun <reified T> get(url: String, base: String = TADO_API) =
        get(serializersModule.serializer<T>(), url, base)

    suspend fun <T> get(s: KSerializer<T>, url: String, base: String = TADO_API) =
        HttpGet("$base$url")
            .apply {
                addHeader(HttpHeaders.AUTHORIZATION, "Bearer ${tokenForGet()}")
            }
            .let { httpGet -> client.execute(httpGet) }
            .let { response -> EntityUtils.toString(response.entity, StandardCharsets.UTF_8) }
            .let { response ->
                try {
                    json.decodeFromString(s, response)
                } catch (e: SerializationException) {
                    throw TadoJsonException(response, e)
                }
            }

    suspend inline fun <reified T, reified U> post(url: String, body: T, base: String = TADO_API) =
        post(serializersModule.serializer<T>(), serializersModule.serializer<U>(), url, body, base)

    suspend fun <T, U> post(bs: KSerializer<T>, s: KSerializer<U>, url: String, body: T, base: String = TADO_API) =
        HttpPost("$base$url")
            .apply {
                addHeader(HttpHeaders.AUTHORIZATION, "Bearer ${tokenForGet()}")
                entity = StringEntity(json.encodeToString(bs, body), ContentType.APPLICATION_JSON)
            }
            .let { httpPut -> client.execute(httpPut) }
            .let { response -> EntityUtils.toString(response.entity, StandardCharsets.UTF_8) }
            .let { response ->
                try {
                    json.decodeFromString(s, response)
                } catch (e: SerializationException) {
                    throw TadoJsonException(response, body, e)
                }
            }

    suspend inline fun <reified T, reified U> put(url: String, body: T, base: String = TADO_API) =
        put(serializersModule.serializer<T>(), serializersModule.serializer<U>(), url, body, base)

    suspend fun <T, U> put(bs: KSerializer<T>, s: KSerializer<U>, url: String, body: T, base: String = TADO_API) =
        HttpPut("$base$url")
            .apply {
                addHeader(HttpHeaders.AUTHORIZATION, "Bearer ${tokenForGet()}")
                entity = StringEntity(json.encodeToString(bs, body), ContentType.APPLICATION_JSON)
            }
            .let { httpPut -> client.execute(httpPut) }
            .let { response -> EntityUtils.toString(response.entity, StandardCharsets.UTF_8) }
            .let { response ->
                try {
                    json.decodeFromString(s, response)
                } catch (e: SerializationException) {
                    throw TadoJsonException(response, body, e)
                }
            }

    suspend fun delete(url: String, base: String = TADO_API): Unit =
        HttpDelete("$base$url")
            .apply {
                addHeader(HttpHeaders.AUTHORIZATION, "Bearer ${tokenForGet()}")
            }
            .let { httpPut -> client.execute(httpPut) }

    override fun close() {
        client.close()
    }

    companion object {
        const val TADO_API = "https://my.tado.com/api/v2"
        const val TADO_AUTH = "https://auth.tado.com"

        internal val json = Json {
            prettyPrint = true
        }
    }
}
