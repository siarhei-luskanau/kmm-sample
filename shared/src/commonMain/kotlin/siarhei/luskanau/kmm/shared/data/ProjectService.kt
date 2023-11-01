package siarhei.luskanau.kmm.shared.data

import siarhei.luskanau.kmm.shared.JsonParser
import siarhei.luskanau.kmm.shared.ResourceReader
import siarhei.luskanau.kmm.shared.parse

class ProjectService(
    private val resourceReader: ResourceReader,
    private val jsonParser: JsonParser
) {

    fun getProject(): Project? = resourceReader.readResource(name = "data.json")?.let { json ->
        jsonParser.parse(json = json)
    }
}
