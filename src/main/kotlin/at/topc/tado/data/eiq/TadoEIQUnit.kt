package at.topc.tado.data.eiq

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class TadoEIQUnit {
    @SerialName("m3")
    METERS_CUBED,

    @SerialName("kWh")
    KILOWATT_HOURS
}
