package at.topc.tado.data.eiq

import kotlinx.datetime.LocalDate

abstract class TadoEIQTariff {
    abstract val unit: TadoEIQUnit
    abstract val startDate: LocalDate
    abstract val endDate: LocalDate?
    abstract val tariffInCents: Double
}
