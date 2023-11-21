package at.topc.tado.data.zone.report.data

import at.topc.tado.data.common.TadoWeatherReport
import at.topc.tado.data.zone.report.TadoZoneReportDataInterval
import kotlinx.serialization.Serializable

@Serializable
data class TadoZoneReportDataIntervalsWeatherCondition(
    override val dataIntervals: List<TadoZoneReportDataInterval<TadoWeatherReport>>
) : TadoZoneReportDataIntervals<TadoWeatherReport>("weatherCondition")