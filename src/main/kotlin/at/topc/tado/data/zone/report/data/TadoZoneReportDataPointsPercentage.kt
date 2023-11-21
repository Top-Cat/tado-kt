package at.topc.tado.data.zone.report.data

import at.topc.tado.data.zone.report.TadoPercentageUnit
import at.topc.tado.data.zone.report.TadoZoneReportDataPoint
import kotlinx.serialization.Serializable

@Serializable
data class TadoZoneReportDataPointsPercentage(
    override val min: Double,
    override val max: Double,
    val percentageUnit: TadoPercentageUnit,
    override val dataPoints: List<TadoZoneReportDataPoint<Double>>
) : TadoZoneReportDataPoints<Double>("percentage")
