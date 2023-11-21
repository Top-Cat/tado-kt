package at.topc.tado.data.common.typed

import at.topc.tado.data.common.TadoTemperature
import at.topc.tado.data.common.TadoPower
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("HOT_WATER")
data class TadoTypedHotWater(val power: TadoPower, val temperature: TadoTemperature? = null) : ITadoTyped
