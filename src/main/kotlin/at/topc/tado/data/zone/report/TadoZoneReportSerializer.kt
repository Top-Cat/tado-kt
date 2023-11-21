package at.topc.tado.data.zone.report

import at.topc.tado.client.TadoClient
import at.topc.tado.data.zone.report.data.ITadoZoneReportData
import at.topc.tado.data.zone.report.data.TadoZoneReportDataIntervalsBoolean
import at.topc.tado.data.zone.report.data.TadoZoneReportDataIntervalsCallForHeat
import at.topc.tado.data.zone.report.data.TadoZoneReportDataIntervalsHeatingSetting
import at.topc.tado.data.zone.report.data.TadoZoneReportDataIntervalsStripes
import at.topc.tado.data.zone.report.data.TadoZoneReportDataIntervalsWeatherCondition
import at.topc.tado.data.zone.report.data.TadoZoneReportDataPointsPercentage
import at.topc.tado.data.zone.report.data.TadoZoneReportDataPointsTemperature
import at.topc.tado.data.zone.report.data.TadoZoneReportSlotsWeatherCondition
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.jsonPrimitive

class TadoZoneReportSerializer : KSerializer<ITadoZoneReportData> {
    private val serializers = mapOf(
        "dataIntervals" to mapOf(
            "boolean" to TadoZoneReportDataIntervalsBoolean.serializer(),
            "stripes" to TadoZoneReportDataIntervalsStripes.serializer(),
            "heatingSetting" to TadoZoneReportDataIntervalsHeatingSetting.serializer(),
            "callForHeat" to TadoZoneReportDataIntervalsCallForHeat.serializer(),
            "weatherCondition" to TadoZoneReportDataIntervalsWeatherCondition.serializer()
        ),
        "dataPoints" to mapOf(
            "temperature" to TadoZoneReportDataPointsTemperature.serializer(),
            "percentage" to TadoZoneReportDataPointsPercentage.serializer()
        ),
        "slots" to mapOf(
            "weatherCondition" to TadoZoneReportSlotsWeatherCondition.serializer()
        )
    )
    private val objectDeserializer = JsonObject.serializer()
    override val descriptor = PrimitiveSerialDescriptor("ITadoZoneReportData", PrimitiveKind.STRING)

    private fun stringOfObject(element: JsonObject, key: String) =
        element[key]?.jsonPrimitive?.content

    override fun serialize(encoder: Encoder, value: ITadoZoneReportData) {
        throw Exception("Unsupported")
    }

    override fun deserialize(decoder: Decoder): ITadoZoneReportData {
        val element = objectDeserializer.deserialize(decoder)
        val timeSeriesType = stringOfObject(element, "timeSeriesType")
        val valueType = stringOfObject(element, "valueType")

        return serializers[timeSeriesType]?.get(valueType)?.let {
            TadoClient.json.decodeFromJsonElement(it, element)
        } ?: throw Exception("Unknown type")
    }
}
