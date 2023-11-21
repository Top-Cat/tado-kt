package at.topc.tado.data.zone.report.data

import at.topc.tado.data.common.TadoTemperature
import at.topc.tado.data.zone.report.TadoZoneReportDataPoint
import kotlinx.serialization.Serializable

@Serializable
data class TadoZoneReportDataPointsTemperature(
    override val min: TadoTemperature,
    override val max: TadoTemperature,
    override val dataPoints: List<TadoZoneReportDataPoint<TadoTemperature>>
) : TadoZoneReportDataPoints<TadoTemperature>("temperature")
