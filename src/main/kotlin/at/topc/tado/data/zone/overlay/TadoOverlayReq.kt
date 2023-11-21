package at.topc.tado.data.zone.overlay

import at.topc.tado.data.common.typed.ITadoTyped
import kotlinx.serialization.Serializable

@Serializable
data class TadoOverlayReq(
    val setting: ITadoTyped,
    val termination: TadoTerminationReq
)
