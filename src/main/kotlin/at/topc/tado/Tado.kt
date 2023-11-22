package at.topc.tado

import at.topc.tado.client.TadoClient
import at.topc.tado.client.TadoClientWithBase
import at.topc.tado.config.TadoConfig
import at.topc.tado.data.user.TadoUser
import java.io.Closeable

class Tado(config: TadoConfig) : Closeable {
    private val tadoClient = TadoClient(config)
    private val tadoClientBase = TadoClientWithBase(tadoClient, TadoClient.TADO_API)

    fun home(id: Int) = TadoHomeApi(tadoClientBase, id)

    suspend fun me() = tadoClientBase.get<TadoUser>("/me")

    override fun close() {
        tadoClient.close()
    }
}
