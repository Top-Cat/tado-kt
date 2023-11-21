package at.topc.tado.data.zone.report.data

import at.topc.tado.data.zone.report.TadoZoneReportDataInterval
import kotlinx.serialization.Serializable

@Serializable
data class TadoZoneReportDataIntervalsBoolean(
    override val dataIntervals: List<TadoZoneReportDataInterval<Boolean>>
) : TadoZoneReportDataIntervals<Boolean>("boolean")
