package at.topc.tado.data.user.device

import kotlinx.serialization.Serializable

@Serializable
data class TadoMobileDeviceBearing(
    val degrees: Double,
    val radians: Double
)
