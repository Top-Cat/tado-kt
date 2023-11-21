package at.topc.tado.data.zone.report.data

import at.topc.tado.data.zone.report.TadoZoneReportDataInterval
import kotlinx.serialization.Serializable

@Serializable
sealed class TadoZoneReportDataIntervals<T>(
    override val valueType: String,
) : ITadoZoneReportData {
    override val timeSeriesType = "dataIntervals"
    abstract val dataIntervals: List<TadoZoneReportDataInterval<T>>
}
