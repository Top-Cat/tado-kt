package at.topc.tado.data.zone

import kotlinx.serialization.Serializable

@Serializable
data class TadoLinkReason(
    val code: String,
    val title: String
)
