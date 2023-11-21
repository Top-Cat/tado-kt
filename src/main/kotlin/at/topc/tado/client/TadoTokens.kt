package at.topc.tado.client

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlin.time.Duration.Companion.seconds

data class TadoTokens(val accessToken: String, val refreshToken: String, val expiry: Instant) {
    constructor(response: TokenResponse) : this(response.accessToken, response.refreshToken, Clock.System.now().plus(response.expiresIn.seconds))
}
