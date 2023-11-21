package at.topc.tado.data.home

import kotlinx.serialization.Serializable

@Serializable
data class TadoContactDetails(
    val name: String,
    val email: String,
    val phone: String
)
