package at.topc.tado.client

class TadoRequestException(response: String, code: Int, body: Any? = null) :
    Exception("Bad response from tado API ($code)\n$body\n$response")
