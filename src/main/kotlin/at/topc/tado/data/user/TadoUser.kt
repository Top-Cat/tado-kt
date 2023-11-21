package at.topc.tado.data.user

import at.topc.tado.data.user.device.TadoMobileDevice
import kotlinx.serialization.Serializable

@Serializable
data class TadoUser(
    val name: String,
    val email: String,
    val username: String,
    val id: String,
    val homes: List<TadoHomeBasic>,
    val locale: String,
    val mobileDevices: List<TadoMobileDevice>
)
