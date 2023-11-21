package at.topc.tado.data.zone.report.data

import at.topc.tado.data.zone.report.TadoZoneReportSerializer
import kotlinx.serialization.Serializable

@Serializable(with = TadoZoneReportSerializer::class)
sealed interface ITadoZoneReportData {
    val timeSeriesType: String
    val valueType: String
}
