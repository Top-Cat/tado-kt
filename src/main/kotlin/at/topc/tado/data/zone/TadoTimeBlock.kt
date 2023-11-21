package at.topc.tado.data.zone

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
data class TadoTimeBlock(val start: Instant? = null, val end: Instant? = null)
