package at.topc.tado.data.user.device

import kotlinx.serialization.Serializable

@Serializable
data class TadoMobileDevicePushNotificationSettings(
    val lowBatteryReminder: Boolean,
    val awayModeReminder: Boolean,
    val homeModeReminder: Boolean,
    val openWindowReminder: Boolean,
    val energySavingsReportReminder: Boolean,
    val incidentDetection: Boolean,
    val energyIqReminder: Boolean,
    val tariffHighPriceAlert: Boolean,
    val tariffLowPriceAlert: Boolean,
    val smartReminders: Boolean? = null
)
