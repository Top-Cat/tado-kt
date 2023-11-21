package at.topc.tado

import at.topc.tado.client.TadoClient
import at.topc.tado.config.TadoConfig
import at.topc.tado.data.user.TadoUser
import java.io.Closeable

class Tado(config: TadoConfig) : Closeable {
    private val tadoClient = TadoClient(config)

    fun home(id: Int) = TadoHomeApi(tadoClient, id)

    suspend fun me() = tadoClient.get<TadoUser>("/me")

    override fun close() {
        tadoClient.close()
    }
}
