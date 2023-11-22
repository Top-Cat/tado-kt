package at.topc.tado.config

data class TadoConfig(
    val email: String,
    val password: String,
    val oauthCreds: TadoOauthCreds = TadoOauthCreds.Preview,
    val renewBeforeExpiry: Int = 20
)
