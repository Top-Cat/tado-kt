package at.topc.tado.data.eiq

import kotlinx.datetime.LocalDate
import kotlinx.datetime.toKotlinLocalDate
import kotlinx.serialization.Serializable

@Serializable
data class TadoEIQTariffReq(
    override val unit: TadoEIQUnit,
    override val startDate: LocalDate,
    override val endDate: LocalDate? = null,
    override val tariffInCents: Double
) : TadoEIQTariff() {
    constructor(unit: TadoEIQUnit, startDate: LocalDate, tariffInCents: Double) :
            this(unit, startDate, null, tariffInCents)
    constructor(unit: TadoEIQUnit, startDate: java.time.LocalDate, tariffInCents: Double) :
            this(unit, startDate.toKotlinLocalDate(), tariffInCents)
    constructor(unit: TadoEIQUnit, startDate: java.time.LocalDate, endDate: java.time.LocalDate, tariffInCents: Double) :
            this(unit, startDate.toKotlinLocalDate(), endDate.toKotlinLocalDate(), tariffInCents)
}
