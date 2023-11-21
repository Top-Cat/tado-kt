package at.topc.tado.data.zone.report.data

import at.topc.tado.data.zone.TadoZoneCallForHeat
import at.topc.tado.data.zone.report.TadoZoneReportDataInterval
import kotlinx.serialization.Serializable

@Serializable
data class TadoZoneReportDataIntervalsCallForHeat(
    override val dataIntervals: List<TadoZoneReportDataInterval<TadoZoneCallForHeat>>
) : TadoZoneReportDataIntervals<TadoZoneCallForHeat>("callForHeat")
