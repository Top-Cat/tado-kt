package at.topc.tado.data.eiq

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class TadoEIQDataSource {
    @SerialName("meterReadings") METER_READINGS,
    @SerialName("heatingBills") HEATING_BILLS
}
