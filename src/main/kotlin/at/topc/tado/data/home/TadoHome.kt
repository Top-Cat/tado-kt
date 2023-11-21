package at.topc.tado.data.home

import at.topc.tado.data.common.feature.BasicTadoFeature
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable
data class TadoHome(
    val id: Int,
    val name: String,
    val dateTimeZone: String,
    val dateCreated: Instant,
    val temperatureUnit: TadoTemperatureUnit,
    val partner: JsonElement,
    val simpleSmartScheduleEnabled: Boolean,
    val awayRadiusInMeters: Double,
    val installationCompleted: Boolean,
    val incidentDetection: BasicTadoFeature,
    val generation: String,
    val zonesCount: Int,
    val skills: Set<TadoSkill>,
    val christmasModeEnabled: Boolean,
    val showAutoAssistReminders: Boolean,
    val contactDetails: TadoContactDetails,
    val address: TadoAddress,
    val geolocation: TadoGeoLocation,
    val consentGrantSkippable: Boolean,
    val enabledFeatures: Set<TadoFeature>,
    val isAirComfortEligible: Boolean,
    val isBalanceAcEligible: Boolean,
    val isBalanceHpEligible: Boolean,
    val isEnergyIqEligible: Boolean,
    val isHeatSourceInstalled: Boolean
)
