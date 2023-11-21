package at.topc.tado

import at.topc.tado.client.TadoClient
import at.topc.tado.data.eiq.TadoEIQReadingReq
import at.topc.tado.data.eiq.TadoEIQReadingRes
import at.topc.tado.data.eiq.TadoEIQReadings
import at.topc.tado.data.eiq.TadoEIQSettings
import at.topc.tado.data.eiq.TadoEIQTariffReq
import at.topc.tado.data.eiq.TadoEIQTariffRes
import at.topc.tado.data.eiq.TadoEIQTariffs

class TadoEIQApi(private val tadoClient: TadoClient, tadoHomeApi: TadoHomeApi) {
    private val baseUri = tadoHomeApi.homeUri
    private val energyIQ = "https://energy-insights.tado.com/api"

    suspend fun getSettings() = tadoClient.get<TadoEIQSettings>("$baseUri/settings", base = energyIQ)
    suspend fun getReadings() = tadoClient.get<TadoEIQReadings>("$baseUri/meterReadings", base = energyIQ)
    suspend fun getTariffs() = tadoClient.get<TadoEIQTariffs>("$baseUri/tariffs", base = energyIQ)

    suspend fun addReading(reading: TadoEIQReadingReq) = tadoClient.post<TadoEIQReadingReq, TadoEIQReadingRes>("$baseUri/meterReadings", reading, base = energyIQ)
    suspend fun updateReading(id: String, reading: TadoEIQReadingReq) = tadoClient.put<TadoEIQReadingReq, TadoEIQReadingRes>("$baseUri/meterReadings/$id", reading, base = energyIQ)
    suspend fun deleteReading(id: String) = tadoClient.delete("$baseUri/meterReadings/$id", base = energyIQ)

    suspend fun addTariff(tariff: TadoEIQTariffReq) = tadoClient.post<TadoEIQTariffReq, TadoEIQTariffRes>("$baseUri/tariffs", tariff, base = energyIQ)
    suspend fun updateTariff(id: String, tariff: TadoEIQTariffReq) = tadoClient.put<TadoEIQTariffReq, TadoEIQTariffRes>("$baseUri/tariffs/$id", tariff, base = energyIQ)
    suspend fun deleteTariff(id: String) = tadoClient.delete("$baseUri/tariffs/$id", base = energyIQ)
}
