package at.topc.tado.data.eiq

import kotlinx.serialization.Serializable

@Serializable
data class TadoEIQTariffs(
    val tariffs: List<TadoEIQTariffRes>
)
