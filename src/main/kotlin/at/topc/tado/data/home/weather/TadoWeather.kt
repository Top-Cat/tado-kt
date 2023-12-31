package at.topc.tado.data.home.weather

import at.topc.tado.data.common.typed.ITadoTyped
import at.topc.tado.data.home.weather.state.ITadoWeatherState
import kotlinx.serialization.Serializable

@Serializable
data class TadoWeather(
    val solarIntensity: ITadoTyped,
    val outsideTemperature: ITadoTyped,
    val weatherState: ITadoWeatherState
)
