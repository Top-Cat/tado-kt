package at.topc.tado.data.zone.report.data

import at.topc.tado.data.common.TadoWeatherReport
import kotlinx.serialization.Serializable

@Serializable
data class TadoZoneReportSlotsWeatherCondition(
    override val slots: Map<String, TadoWeatherReport>
) : TadoZoneReportSlots<TadoWeatherReport>("weatherCondition")
