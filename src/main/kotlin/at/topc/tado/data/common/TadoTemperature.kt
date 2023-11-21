package at.topc.tado.data.common

import kotlinx.serialization.Serializable

@Serializable
data class TadoTemperature(val celsius: Double, val fahrenheit: Double) {
    companion object {
        fun celsius(c: Double) = TadoTemperature(c, (c * 9) / 5.0 + 32)
        fun fahrenheit(f: Double) = TadoTemperature(((f - 32) * 5) / 9.0, f)
    }
}
