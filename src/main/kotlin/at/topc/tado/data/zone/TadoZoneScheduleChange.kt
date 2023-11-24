package at.topc.tado.data.zone

import at.topc.tado.data.common.typed.ITadoTyped
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
data class TadoZoneScheduleChange(
    val start: Instant,
    val setting: ITadoTyped
)
