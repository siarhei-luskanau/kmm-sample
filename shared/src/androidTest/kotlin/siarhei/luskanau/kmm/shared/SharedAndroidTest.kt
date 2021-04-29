package siarhei.luskanau.kmm.shared

import android.app.Application
import androidx.test.core.app.ApplicationProvider
import com.jetbrains.kmm.shared.Calculator
import kotlin.test.assertEquals
import org.junit.Ignore
import org.junit.Test

class SharedAndroidTest {

    @Test
    @Ignore("kmm doesn't work with context")
    fun sharedAndroidTestResourceReader() {
        val context = ApplicationProvider.getApplicationContext<Application>()
        val actual = ResourceReader(context = context).readResource("data.json")
        assertEquals(
            expected = "{\n" +
                "  \"name\": \"kotlinx.serialization\",\n" +
                "  \"language\": \"Kotlin\"\n" +
                "}\n",
            actual = actual
        )
    }

    @Test
    fun sharedAndroidTestSum() {
        assertEquals(3, Calculator.sum(1, 2))
    }
}
