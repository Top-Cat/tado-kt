package at.topc.tado

import at.topc.tado.client.TadoClientWithBase
import at.topc.tado.data.zone.TadoZone
import at.topc.tado.data.zone.TadoZoneState
import at.topc.tado.data.zone.overlay.ITadoOverlayRes
import at.topc.tado.data.zone.overlay.TadoOverlayReq
import at.topc.tado.data.zone.report.TadoZoneReport
import java.time.LocalDate

class TadoZoneApi(client: TadoClientWithBase, zoneId: Int) {
    private val tadoClient = client.plusBase("/zones/$zoneId")

    suspend fun getDetails() = tadoClient.get<TadoZone>("/details")
    suspend fun getState() = tadoClient.get<TadoZoneState>("/state")

    suspend fun addOverlay(overlay: TadoOverlayReq) = tadoClient.put<TadoOverlayReq, ITadoOverlayRes>("/overlay", overlay)
    suspend fun deleteOverlay() = tadoClient.delete("/overlay")

    suspend fun getDayReport(date: LocalDate) = tadoClient.get<TadoZoneReport>("/dayReport?date=$date")
}
