package at.topc.tado.data.zone

import at.topc.tado.data.common.TadoMode
import at.topc.tado.data.common.typed.ITadoTyped
import at.topc.tado.data.zone.overlay.ITadoOverlayRes
import at.topc.tado.data.zone.overlay.TadoOverlayType
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable
data class TadoZoneState(
    val tadoMode: TadoMode,
    val geolocationOverride: Boolean,
    val geolocationOverrideDisableTime: Instant?,
    val preparation: JsonElement,
    val setting: ITadoTyped,
    val overlayType: TadoOverlayType?,
    val overlay: ITadoOverlayRes?,
    val openWindow: JsonElement,
    val nextScheduleChange: TadoZoneScheduleChange?,
    val nextTimeBlock: TadoTimeBlock?,
    val link: TadoLink,
    val runningOfflineSchedule: Boolean,
    val activityDataPoints: Map<String, ITadoTyped>,
    val sensorDataPoints: Map<String, ITadoTyped>
)
