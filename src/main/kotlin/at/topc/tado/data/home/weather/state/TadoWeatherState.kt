package at.topc.tado.data.home.weather.state

import at.topc.tado.data.home.weather.TadoWeatherType
import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("WEATHER_STATE")
data class TadoWeatherState(
    val value: TadoWeatherType,
    val timestamp: Instant
) : ITadoWeatherState
