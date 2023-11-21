package at.topc.tado

import at.topc.tado.client.TadoClient
import at.topc.tado.data.home.TadoHome
import at.topc.tado.data.home.TadoHomeState
import at.topc.tado.data.home.weather.TadoWeather
import at.topc.tado.data.user.TadoUser
import at.topc.tado.data.zone.TadoZone

class TadoHomeApi(private val tadoClient: TadoClient, homeId: Int) {
    internal val homeUri = "/homes/$homeId"
    fun zone(id: Int) = TadoZoneApi(tadoClient, this, id)
    fun energyIQ() = TadoEIQApi(tadoClient, this)

    suspend fun getInfo() = tadoClient.get<TadoHome>(homeUri)
    suspend fun getZones() = tadoClient.get<List<TadoZone>>("$homeUri/zones")
    suspend fun getState() = tadoClient.get<TadoHomeState>("$homeUri/state")
    suspend fun getWeather() = tadoClient.get<TadoWeather>("$homeUri/weather")
    suspend fun getUsers() = tadoClient.get<List<TadoUser>>("$homeUri/users")
}
