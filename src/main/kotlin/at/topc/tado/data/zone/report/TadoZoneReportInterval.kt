package at.topc.tado.data.zone.report

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
data class TadoZoneReportInterval(
    val from: Instant,
    val to: Instant
)
