package at.topc.tado.data.eiq

import kotlinx.datetime.LocalDate
import kotlinx.datetime.toKotlinLocalDate
import kotlinx.serialization.Serializable

@Serializable
data class TadoEIQReadingReq(
    override val reading: Int,
    override val date: LocalDate
) : TadoEIQReading() {
    constructor(reading: Int, date: java.time.LocalDate) :
        this(reading, date.toKotlinLocalDate())
}
