package at.topc.tado.config

data class TadoConfig(
    val email: String,
    val oauthCreds: TadoOauthCreds = TadoOauthCreds.Login,
    val renewBeforeExpiry: Int = 20
)
