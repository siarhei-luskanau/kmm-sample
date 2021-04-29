package siarhei.luskanau.kmm.shared

expect class ResourceReader {
    fun readResource(name: String): String?
}
