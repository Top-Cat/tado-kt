package at.topc.tado.data.zone.overlay.termination

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("TIMER")
data class TadoTerminationTimer(
    override val typeSkillBasedApp: TadoTerminationSkill,
    val durationInSeconds: Int,
    val expiry: Instant,
    val remainingTimeInSeconds: Int,
    override val projectedExpiry: Instant
) : ITadoTermination
