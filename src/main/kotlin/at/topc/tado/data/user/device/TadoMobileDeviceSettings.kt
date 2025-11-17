package at.topc.tado.data.user.device

import kotlinx.serialization.Serializable

@Serializable
data class TadoMobileDeviceSettings(
    val geoTrackingEnabled: Boolean,
    val specialOffersEnabled: Boolean,
    val onDemandLogRetrievalEnabled: Boolean,
    val smartRemindersInAppEnabled: Boolean? = null,
    val pushNotifications: TadoMobileDevicePushNotificationSettings? = null
)
