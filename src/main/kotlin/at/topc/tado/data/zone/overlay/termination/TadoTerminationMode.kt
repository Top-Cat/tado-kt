package at.topc.tado.data.zone.overlay.termination

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("TADO_MODE")
data class TadoTerminationMode(
    override val typeSkillBasedApp: TadoTerminationSkill,
    override val projectedExpiry: Instant
) : ITadoTermination
