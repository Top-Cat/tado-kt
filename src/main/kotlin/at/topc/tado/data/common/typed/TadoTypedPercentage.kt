package at.topc.tado.data.common.typed

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("PERCENTAGE")
data class TadoTypedPercentage(val percentage: Double, val timestamp: Instant) : ITadoTyped
