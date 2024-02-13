package at.topc.tado.data.common.feature

import kotlinx.serialization.Serializable

@Serializable
data class TadoZoneOpenWindowDetection(
    override val supported: Boolean,
    override val enabled: Boolean? = null,
    val timeoutInSeconds: Int? = null
) : ITadoFeature
