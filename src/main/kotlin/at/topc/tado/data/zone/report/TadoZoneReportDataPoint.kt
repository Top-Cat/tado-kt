package at.topc.tado.data.zone.report

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
data class TadoZoneReportDataPoint<T>(
    val timestamp: Instant,
    val value: T
)
