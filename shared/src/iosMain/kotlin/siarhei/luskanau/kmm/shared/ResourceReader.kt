package siarhei.luskanau.kmm.shared

import platform.Foundation.NSBundle
import platform.Foundation.NSFileManager
import platform.Foundation.NSString
import platform.Foundation.NSUTF8StringEncoding
import platform.Foundation.create

actual class ResourceReader(
    val bundle: NSBundle
) {

    actual fun readResource(name: String): String? =
        bundle.pathForResource(name, null)?.let { path ->
            NSFileManager.defaultManager.contentsAtPath(path)?.let { nsData ->
                NSString.create(nsData, NSUTF8StringEncoding) as String?
            }
        }
}
