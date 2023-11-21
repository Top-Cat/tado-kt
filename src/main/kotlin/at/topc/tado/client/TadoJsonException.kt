package at.topc.tado.client

class TadoJsonException(response: String, body: Any? = null, cause: Exception) :
    Exception("Failed to parse tado response\n$body\n$response", cause) {
    constructor(response: String, cause: Exception) : this(response, null, cause)
}
