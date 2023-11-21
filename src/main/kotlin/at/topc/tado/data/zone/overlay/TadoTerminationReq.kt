package at.topc.tado.data.zone.overlay

import at.topc.tado.data.zone.overlay.termination.TadoTerminationSkill
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import kotlin.time.DurationUnit

@Serializable
data class TadoTerminationReq(
    val typeSkillBasedApp: TadoTerminationSkill,
    val durationInSeconds: Int? = null
) {
    companion object {
        fun untilNext() = TadoTerminationReq(TadoTerminationSkill.NEXT_TIME_BLOCK)
        fun manual() = TadoTerminationReq(TadoTerminationSkill.MANUAL)
        fun until(time: Instant) = TadoTerminationReq(TadoTerminationSkill.TIMER, (time - Clock.System.now()).toInt(DurationUnit.SECONDS))
    }
}
