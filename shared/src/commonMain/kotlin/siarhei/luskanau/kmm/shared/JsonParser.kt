package siarhei.luskanau.kmm.shared

import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json

class JsonParser(
    private val resourceReader: ResourceReader
) {

    private val parser = Json { ignoreUnknownKeys = true }

    fun <T : Any> parse(
        name: String,
        serializer: KSerializer<T>,
    ): T? =
        resourceReader.readResource(name)?.let { json ->
            parser.decodeFromString(serializer, json)
        }
}
