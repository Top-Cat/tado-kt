package at.topc.tado.data.zone.report.data

import at.topc.tado.data.zone.report.TadoZoneReportDataPoint
import kotlinx.serialization.Serializable

@Serializable
sealed class TadoZoneReportDataPoints<T>(
    override val valueType: String
) : ITadoZoneReportData {
    override val timeSeriesType = "dataPoints"
    abstract val min: T
    abstract val max: T
    abstract val dataPoints: List<TadoZoneReportDataPoint<T>>
}
