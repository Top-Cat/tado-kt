package at.topc.tado

import at.topc.tado.client.TadoClientWithBase
import at.topc.tado.data.home.TadoHome
import at.topc.tado.data.home.TadoHomeState
import at.topc.tado.data.home.TadoZoneStates
import at.topc.tado.data.home.weather.TadoWeather
import at.topc.tado.data.user.TadoUser
import at.topc.tado.data.zone.TadoZone

class TadoHomeApi(client: TadoClientWithBase, homeId: Int) {
    private val baseUri = "/homes/$homeId"
    private val tadoClient = client.plusBase(baseUri)
    fun zone(id: Int) = TadoZoneApi(tadoClient, id)
    fun energyIQ() = TadoEIQApi(tadoClient, baseUri)

    suspend fun getInfo() = tadoClient.get<TadoHome>("")
    suspend fun getZones() = tadoClient.get<List<TadoZone>>("/zones")
    suspend fun getZoneStates() = tadoClient.get<TadoZoneStates>("/zoneStates")
    suspend fun getState() = tadoClient.get<TadoHomeState>("/state")
    suspend fun getWeather() = tadoClient.get<TadoWeather>("/weather")
    suspend fun getUsers() = tadoClient.get<List<TadoUser>>("/users")
}
