package at.topc.tado.data.zone.report.data

import kotlinx.serialization.Serializable

@Serializable
sealed class TadoZoneReportSlots<T>(
    override val valueType: String,
) : ITadoZoneReportData {
    override val timeSeriesType = "slots"
    abstract val slots: Map<String, T>
}
