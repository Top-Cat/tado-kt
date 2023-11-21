package at.topc.tado.data.user.device

import kotlinx.serialization.Serializable

@Serializable
data class TadoMobileDeviceLocation(
    val stale: Boolean,
    val atHome: Boolean,
    val bearingFromHome: TadoMobileDeviceBearing,
    val relativeDistanceFromHomeFence: Double
)
