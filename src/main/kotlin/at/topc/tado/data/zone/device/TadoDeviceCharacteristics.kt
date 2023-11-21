package at.topc.tado.data.zone.device

import kotlinx.serialization.Serializable

@Serializable
data class TadoDeviceCharacteristics(
    val capabilities: Set<TadoDeviceCapability>
)
