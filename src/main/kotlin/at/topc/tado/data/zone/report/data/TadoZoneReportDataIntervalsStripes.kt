package at.topc.tado.data.zone.report.data

import at.topc.tado.data.zone.report.TadoZoneReportDataInterval
import at.topc.tado.data.zone.report.stripe.ITadoZoneReportStripe
import kotlinx.serialization.Serializable

@Serializable
data class TadoZoneReportDataIntervalsStripes(
    override val dataIntervals: List<TadoZoneReportDataInterval<ITadoZoneReportStripe>>
) : TadoZoneReportDataIntervals<ITadoZoneReportStripe>("stripes")
