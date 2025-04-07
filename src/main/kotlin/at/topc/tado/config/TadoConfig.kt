package at.topc.tado.config

data class TadoConfig(
    val email: String,
    val refreshToken: String? = null,
    val oauthCreds: TadoOauthCreds = TadoOauthCreds.Login,
    val renewBeforeExpiry: Int = 20,
    val persistRefreshToken: ((String) -> Unit)? = null
)
