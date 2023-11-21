package at.topc.tado.data.zone.report.stripe

import at.topc.tado.data.common.typed.ITadoTyped
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("OVERLAY_ACTIVE")
data class TadoZoneReportStripeOverlay(
    val setting: ITadoTyped
) : ITadoZoneReportStripe