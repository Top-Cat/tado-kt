package at.topc.tado.config

data class TadoConfig(
    val oauthCreds: TadoOauthCreds = TadoOauthCreds.Preview,
    val email: String,
    val password: String
)
