package siarhei.luskanau.kmm.shared.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Project(
    @SerialName("name") val name: String,
    @SerialName("language") val language: String,
)
