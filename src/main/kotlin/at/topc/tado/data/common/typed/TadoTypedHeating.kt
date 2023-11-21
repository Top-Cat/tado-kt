package at.topc.tado.data.common.typed

import at.topc.tado.data.common.TadoPower
import at.topc.tado.data.common.TadoTemperature
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("HEATING")
data class TadoTypedHeating(val power: TadoPower, val temperature: TadoTemperature?) : ITadoTyped
