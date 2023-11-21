package at.topc.tado.data.eiq

import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable

@Serializable
data class TadoEIQReadingRes(
    val id: String,
    val homeId: Int,
    override val reading: Int,
    override val date: LocalDate
) : TadoEIQReading()
