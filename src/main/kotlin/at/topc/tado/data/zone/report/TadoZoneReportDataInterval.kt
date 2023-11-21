package at.topc.tado.data.zone.report

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
data class TadoZoneReportDataInterval<T>(
    val from: Instant,
    val to: Instant,
    val value: T
)
