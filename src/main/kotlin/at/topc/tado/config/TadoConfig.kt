package at.topc.tado.config

import at.topc.tado.client.DeviceCodeResponse

data class TadoConfig(
    val email: String,
    val refreshToken: String? = null,
    val oauthCreds: TadoOauthCreds = TadoOauthCreds.Login,
    val renewBeforeExpiry: Int = 20,
    val persistRefreshToken: (suspend (String) -> Unit)? = null,
    val deviceCodeHandler: (suspend (DeviceCodeResponse) -> Unit)? = null
)
