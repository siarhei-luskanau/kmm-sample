package siarhei.luskanau.kmm.shared

import android.content.Context

actual class ResourceReader constructor(
    private val context: Context
) {
    actual fun readResource(name: String): String? =
        runCatching {
            context.assets.open(name)
                .bufferedReader()
                .use { it.readText() }
        }.getOrNull()
}
