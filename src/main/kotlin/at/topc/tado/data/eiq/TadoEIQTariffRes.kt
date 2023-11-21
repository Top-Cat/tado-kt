package at.topc.tado.data.eiq

import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable

@Serializable
data class TadoEIQTariffRes(
    override val unit: TadoEIQUnit,
    val lastUpdated: Instant? = null,
    val homeId: Int,
    override val startDate: LocalDate,
    override val endDate: LocalDate? = null,
    override val tariffInCents: Double,
    val id: String
) : TadoEIQTariff()
