package at.topc.tado.data.home

import at.topc.tado.data.zone.TadoZoneState
import kotlinx.serialization.Serializable

@Serializable
data class TadoZoneStates(
    val zoneStates: Map<Int, TadoZoneState>
)
