package at.topc.tado

import at.topc.tado.client.TadoClientWithBase
import at.topc.tado.data.eiq.TadoEIQReadingReq
import at.topc.tado.data.eiq.TadoEIQReadingRes
import at.topc.tado.data.eiq.TadoEIQReadings
import at.topc.tado.data.eiq.TadoEIQSettings
import at.topc.tado.data.eiq.TadoEIQTariffReq
import at.topc.tado.data.eiq.TadoEIQTariffRes
import at.topc.tado.data.eiq.TadoEIQTariffs

class TadoEIQApi(client: TadoClientWithBase, baseUri: String) {
    private val energyIQ = "https://energy-insights.tado.com/api"
    private val tadoClient = client.withBase("$energyIQ$baseUri")

    suspend fun getSettings() = tadoClient.get<TadoEIQSettings>("/settings")
    suspend fun getReadings() = tadoClient.get<TadoEIQReadings>("/meterReadings")
    suspend fun getTariffs() = tadoClient.get<TadoEIQTariffs>("/tariffs")

    suspend fun addReading(reading: TadoEIQReadingReq) = tadoClient.post<TadoEIQReadingReq, TadoEIQReadingRes>("/meterReadings", reading)
    suspend fun updateReading(id: String, reading: TadoEIQReadingReq) = tadoClient.put<TadoEIQReadingReq, TadoEIQReadingRes>("/meterReadings/$id", reading)
    suspend fun deleteReading(id: String) = tadoClient.delete("/meterReadings/$id")

    suspend fun addTariff(tariff: TadoEIQTariffReq) = tadoClient.post<TadoEIQTariffReq, TadoEIQTariffRes>("/tariffs", tariff)
    suspend fun updateTariff(id: String, tariff: TadoEIQTariffReq) = tadoClient.put<TadoEIQTariffReq, TadoEIQTariffRes>("/tariffs/$id", tariff)
    suspend fun deleteTariff(id: String) = tadoClient.delete("/tariffs/$id")
}
