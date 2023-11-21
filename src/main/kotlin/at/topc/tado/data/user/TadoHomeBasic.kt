package at.topc.tado.data.user

import kotlinx.serialization.Serializable

@Serializable
data class TadoHomeBasic(
    val id: Int,
    val name: String
)
