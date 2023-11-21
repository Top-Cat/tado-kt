package at.topc.tado.data.zone.report

import at.topc.tado.data.zone.TadoZoneType
import at.topc.tado.data.zone.report.data.ITadoZoneReportData
import kotlinx.serialization.Serializable

@Serializable
data class TadoZoneReport(
    val zoneType: TadoZoneType,
    val interval: TadoZoneReportInterval,
    val hoursInDay: Int,
    val measuredData: TadoZoneReportMeasuredData,
    val stripes: ITadoZoneReportData,
    val settings: ITadoZoneReportData,
    val callForHeat: ITadoZoneReportData,
    val weather: TadoZoneReportWeather
)
