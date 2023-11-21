package at.topc.tado.data.common.feature

import kotlinx.serialization.Serializable

@Serializable
data class BasicTadoFeature(
    override val supported: Boolean,
    override val enabled: Boolean
) : ITadoFeature