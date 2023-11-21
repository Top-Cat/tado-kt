package at.topc.tado.data.common

import at.topc.tado.data.home.weather.TadoWeatherType
import kotlinx.serialization.Serializable

@Serializable
data class TadoWeatherReport(
    val state: TadoWeatherType,
    val temperature: TadoTemperature
)
