package at.topc.tado.client

import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json.Default.serializersModule
import kotlinx.serialization.serializer

class TadoClientWithBase(private val client: TadoClient, private val base: String) {
    suspend inline fun <reified T> get(url: String) =
        get(serializersModule.serializer<T>(), url)

    suspend fun <T> get(s: KSerializer<T>, url: String) =
        client.get(s, "$base$url")

    suspend inline fun <reified T, reified U> post(url: String, body: T) =
        post(serializersModule.serializer<T>(), serializersModule.serializer<U>(), url, body)

    suspend fun <T, U> post(bs: KSerializer<T>, s: KSerializer<U>, url: String, body: T) =
        client.post(bs, s, "$base$url", body)

    suspend inline fun <reified T, reified U> put(url: String, body: T) =
        put(serializersModule.serializer<T>(), serializersModule.serializer<U>(), url, body)

    suspend fun <T, U> put(bs: KSerializer<T>, s: KSerializer<U>, url: String, body: T) =
        client.put(bs, s, "$base$url", body)

    suspend fun delete(url: String): Unit =
        client.delete("$base$url")

    fun plusBase(b: String) = TadoClientWithBase(client, "$base$b")
    fun withBase(b: String) = TadoClientWithBase(client, b)
}
