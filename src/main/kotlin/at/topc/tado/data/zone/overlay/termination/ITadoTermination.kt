package at.topc.tado.data.zone.overlay.termination

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
sealed interface ITadoTermination {
    val typeSkillBasedApp: TadoTerminationSkill
    val projectedExpiry: Instant?
}
