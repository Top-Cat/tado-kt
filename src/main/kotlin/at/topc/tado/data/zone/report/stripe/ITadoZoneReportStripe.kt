@file:OptIn(ExperimentalSerializationApi::class)

package at.topc.tado.data.zone.report.stripe

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonClassDiscriminator

@Serializable
@JsonClassDiscriminator("stripeType")
sealed interface ITadoZoneReportStripe

