package at.topc.tado.data.zone.device

import kotlinx.serialization.Serializable

@Serializable
data class TadoDevice(
    val deviceType: TadoDeviceType,
    val serialNo: String,
    val shortSerialNo: String,
    val currentFwVersion: String,
    val connectionState: TadoStateWithTime<Boolean>,
    val characteristics: TadoDeviceCharacteristics,
    val mountingState: TadoStateWithTime<TadoDeviceMountingStateEnum>? = null,
    val mountingStateWithError: TadoDeviceMountingStateEnum? = null,
    val batteryState: TadoDeviceBatteryState? = null,
    val orientation: TadoDeviceOrientation? = null,
    val childLockEnabled: Boolean? = null,
    val isDriverConfigured: Boolean? = null,
    val duties: Set<TadoDeviceDuty>
)
