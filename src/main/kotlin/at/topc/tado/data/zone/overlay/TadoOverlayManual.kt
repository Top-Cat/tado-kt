package at.topc.tado.data.zone.overlay

import at.topc.tado.data.common.typed.ITadoTyped
import at.topc.tado.data.zone.overlay.termination.ITadoTermination
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("MANUAL")
data class TadoOverlayManual(
    val setting: ITadoTyped,
    val termination: ITadoTermination
) : ITadoOverlayRes
