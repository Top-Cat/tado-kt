package at.topc.tado.client

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TokenResponse(
    @SerialName("access_token")
    val accessToken: String,
    @SerialName("token_type")
    val tokenType: String,
    @SerialName("refresh_token")
    val refreshToken: String,
    @SerialName("refresh_token_id")
    val refreshTokenId: String,
    @SerialName("expires_in")
    val expiresIn: Int,
    val scope: String,
    val userId: String
)
