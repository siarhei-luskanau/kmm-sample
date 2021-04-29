package siarhei.luskanau.kmm.shared

import platform.Foundation.NSBundle

actual class ResourceReader(
    val bundle: NSBundle
) {

    actual fun readResource(name: String): String? =
        "{\n" +
            "  \"name\": \"kotlinx.serialization\",\n" +
            "  \"language\": \"${bundle}\"\n" +
            "}\n"
}
