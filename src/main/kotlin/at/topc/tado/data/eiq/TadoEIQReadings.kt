package at.topc.tado.data.eiq

import kotlinx.serialization.Serializable

@Serializable
data class TadoEIQReadings(
    val readings: List<TadoEIQReadingRes>
)
