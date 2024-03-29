package siarhei.luskanau.kmm.shared

import android.app.Application
import androidx.test.core.app.ApplicationProvider
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class SharedAndroidAndroidTest {

    @Test
    fun successResourceReaderSharedAndroidAndroidTest() {
        val context = ApplicationProvider.getApplicationContext<Application>()
        val actual = ResourceReader(context = context).readResource("test.json")
        assertEquals(
            expected = "{\n" +
                "  \"test-key\": \"test-value\"\n" +
                "}\n",
            actual = actual
        )
    }

    @Test
    fun notExistResourceReaderSharedAndroidAndroidTest() {
        val context = ApplicationProvider.getApplicationContext<Application>()
        val actual = ResourceReader(context = context).readResource("not_exist.json")
        assertNull(actual = actual)
    }
}
