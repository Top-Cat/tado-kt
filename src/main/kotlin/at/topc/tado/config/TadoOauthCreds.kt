package at.topc.tado.config

enum class TadoOauthCreds(val clientId: String, val clientSecret: String) {
    Preview("public-api-preview", "4HJGRffVR8xb3XdEUQpjgZ1VplJi6Xgw"),
    WebApp("tado-web-app", "wZaRN7rpjn3FoNyF5IFuxg9uMzYJcvOoQ8QWiIqS3hfk6gLhVlG57j5YNoZL2Rtc")
}
