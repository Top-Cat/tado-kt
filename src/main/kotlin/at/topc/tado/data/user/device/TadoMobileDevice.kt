package at.topc.tado.data.user.device

import kotlinx.serialization.Serializable

@Serializable
data class TadoMobileDevice(
    val name: String,
    val id: Int,
    val settings: TadoMobileDeviceSettings,
    val location: TadoMobileDeviceLocation,
    val deviceMetadata: TadoMobileDeviceMetadata
)
