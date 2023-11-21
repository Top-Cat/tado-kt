package at.topc.tado.data.eiq

import kotlinx.datetime.LocalDate

abstract class TadoEIQReading {
    abstract val reading: Int
    abstract val date: LocalDate
}

