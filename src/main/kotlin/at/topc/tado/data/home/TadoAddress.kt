package at.topc.tado.data.home

import kotlinx.serialization.Serializable

@Serializable
data class TadoAddress(
    val addressLine1: String,
    val addressLine2: String?,
    val zipCode: String,
    val city: String,
    val state: String?,
    val country: String
)
