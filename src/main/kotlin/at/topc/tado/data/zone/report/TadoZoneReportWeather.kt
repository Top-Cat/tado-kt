package at.topc.tado.data.zone.report

import at.topc.tado.data.zone.report.data.ITadoZoneReportData
import kotlinx.serialization.Serializable

@Serializable
data class TadoZoneReportWeather(
    val condition: ITadoZoneReportData,
    val sunny: ITadoZoneReportData,
    val slots: ITadoZoneReportData
)
