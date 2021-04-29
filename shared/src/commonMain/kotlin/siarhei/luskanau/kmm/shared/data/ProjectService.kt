package siarhei.luskanau.kmm.shared.data

import siarhei.luskanau.kmm.shared.JsonParser

class ProjectService(
    private val jsonParser: JsonParser,
) {

    fun getProject(): Project? =
        jsonParser.parse(
            name = "data.json",
            serializer = Project.serializer(),
        )
}
