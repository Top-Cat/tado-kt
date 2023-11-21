package at.topc.tado

import at.topc.tado.client.TadoClient
import at.topc.tado.data.zone.TadoZone
import at.topc.tado.data.zone.TadoZoneState
import at.topc.tado.data.zone.report.TadoZoneReport
import at.topc.tado.data.zone.overlay.ITadoOverlayRes
import at.topc.tado.data.zone.overlay.TadoOverlayReq
import java.time.LocalDate

class TadoZoneApi(private val tadoClient: TadoClient, tadoHomeApi: TadoHomeApi, zoneId: Int) {
    private val zoneUri = "${tadoHomeApi.homeUri}/zones/$zoneId"

    suspend fun getDetails() = tadoClient.get<TadoZone>("$zoneUri/details")
    suspend fun getState() = tadoClient.get<TadoZoneState>("$zoneUri/state")

    suspend fun addOverlay(overlay: TadoOverlayReq) = tadoClient.put<TadoOverlayReq, ITadoOverlayRes>("$zoneUri/overlay", overlay)
    suspend fun deleteOverlay() = tadoClient.delete("$zoneUri/overlay")

    suspend fun getDayReport(date: LocalDate) = tadoClient.get<TadoZoneReport>("$zoneUri/dayReport?date=$date")
}
