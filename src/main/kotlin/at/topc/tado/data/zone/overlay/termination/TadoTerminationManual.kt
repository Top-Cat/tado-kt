package at.topc.tado.data.zone.overlay.termination

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("MANUAL")
data class TadoTerminationManual(
    override val typeSkillBasedApp: TadoTerminationSkill,
    override val projectedExpiry: Instant?
) : ITadoTermination
