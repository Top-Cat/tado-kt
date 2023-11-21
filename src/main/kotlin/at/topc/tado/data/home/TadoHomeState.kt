package at.topc.tado.data.home

import at.topc.tado.data.common.TadoMode
import kotlinx.serialization.Serializable

@Serializable
data class TadoHomeState(
    val presence: TadoMode,
    val presenceLocked: Boolean
)
