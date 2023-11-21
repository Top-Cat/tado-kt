package at.topc.tado.data.home

import kotlinx.serialization.Serializable

@Serializable
data class TadoGeoLocation(
    val latitude: Double,
    val longitude: Double
)
