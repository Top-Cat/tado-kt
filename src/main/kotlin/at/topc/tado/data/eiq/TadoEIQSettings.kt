package at.topc.tado.data.eiq

import kotlinx.serialization.Serializable

@Serializable
data class TadoEIQSettings(
    val consumptionUnit: TadoEIQUnit,
    val dataSource: TadoEIQDataSource,
    val homeId: Int,
    val preferredEnergyUnit: TadoEIQUnit,
    val showReadingsBanner: Boolean
)
