package at.topc.tado.data.common.typed

import at.topc.tado.data.common.TadoTemperature
import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("TEMPERATURE")
data class TadoTypedTemperature(val celsius: Double, val fahrenheit: Double, val timestamp: Instant, val precision: TadoTemperature) : ITadoTyped
