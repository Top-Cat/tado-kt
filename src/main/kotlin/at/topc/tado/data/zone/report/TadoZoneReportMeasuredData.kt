package at.topc.tado.data.zone.report

import at.topc.tado.data.zone.report.data.ITadoZoneReportData
import kotlinx.serialization.Serializable

@Serializable
data class TadoZoneReportMeasuredData(
    val measuringDeviceConnected: ITadoZoneReportData,
    val insideTemperature: ITadoZoneReportData,
    val humidity: ITadoZoneReportData
)
