package at.topc.tado.data.user.device

import kotlinx.serialization.Serializable

@Serializable
data class TadoMobileDeviceMetadata(
    val platform: String,
    val osVersion: String,
    val model: String,
    val locale: String
)
