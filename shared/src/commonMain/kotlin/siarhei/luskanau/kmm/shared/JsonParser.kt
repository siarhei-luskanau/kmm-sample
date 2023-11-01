package siarhei.luskanau.kmm.shared

import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json
import kotlinx.serialization.serializer

class JsonParser {

    private val parser = Json { ignoreUnknownKeys = true }

    fun <T : Any> parseBySerializer(json: String, serializer: KSerializer<T>): T =
        parser.decodeFromString(serializer, json)
}

@OptIn(InternalSerializationApi::class)
inline fun <reified T : Any> JsonParser.parse(json: String): T? =
    parseBySerializer(json, T::class.serializer())
