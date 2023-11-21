package at.topc.tado.data.zone

import at.topc.tado.data.zone.device.TadoDevice
import at.topc.tado.data.zone.device.TadoDeviceType
import at.topc.tado.data.common.feature.BasicTadoFeature
import at.topc.tado.data.common.feature.TadoZoneOpenWindowDetection
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
data class TadoZone(
    val id: Int,
    val name: String,
    val type: TadoZoneType,
    val dateCreated: Instant,
    val deviceTypes: List<TadoDeviceType>,
    val devices: List<TadoDevice>,
    val reportAvailable: Boolean,
    val showScheduleSetup: Boolean,
    val supportsDazzle: Boolean,
    val dazzleEnabled: Boolean,
    val dazzleMode: BasicTadoFeature,
    val openWindowDetection: TadoZoneOpenWindowDetection
)
