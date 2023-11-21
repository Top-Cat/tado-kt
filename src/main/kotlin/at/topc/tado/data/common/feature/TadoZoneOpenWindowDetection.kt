package at.topc.tado.data.common.feature

import kotlinx.serialization.Serializable

@Serializable
data class TadoZoneOpenWindowDetection(
    override val supported: Boolean,
    override val enabled: Boolean,
    val timeoutInSeconds: Int
) : ITadoFeature
