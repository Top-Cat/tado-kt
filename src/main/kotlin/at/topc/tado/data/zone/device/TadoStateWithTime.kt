package at.topc.tado.data.zone.device

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
data class TadoStateWithTime<T>(
    val value: T,
    val timestamp: Instant
)
