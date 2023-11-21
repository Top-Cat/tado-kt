package at.topc.tado.data.zone.report.data

import at.topc.tado.data.common.typed.ITadoTyped
import at.topc.tado.data.zone.report.TadoZoneReportDataInterval
import kotlinx.serialization.Serializable

@Serializable
data class TadoZoneReportDataIntervalsHeatingSetting(
    override val dataIntervals: List<TadoZoneReportDataInterval<ITadoTyped>>
) : TadoZoneReportDataIntervals<ITadoTyped>("heatingSetting")