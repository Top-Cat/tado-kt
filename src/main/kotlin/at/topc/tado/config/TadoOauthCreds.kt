package at.topc.tado.config

enum class TadoOauthCreds(val clientId: String, val clientSecret: String) {
    Preview("public-api-preview", "4HJGRffVR8xb3XdEUQpjgZ1VplJi6Xgw"),
    WebApp("tado-web-app", "wZaRN7rpjn3FoNyF5IFuxg9uMzYJcvOoQ8QWiIqS3hfk6gLhVlG57j5YNoZL2Rtc"),
    Login("1bb50063-6b0c-4d11-bd99-387f4a91cc46", "")
}
