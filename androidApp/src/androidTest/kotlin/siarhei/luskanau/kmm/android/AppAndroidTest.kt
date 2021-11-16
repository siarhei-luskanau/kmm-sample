package siarhei.luskanau.kmm.android

import androidx.test.platform.app.InstrumentationRegistry
import kotlin.test.Test
import kotlin.test.assertEquals
import siarhei.luskanau.kmm.shared.Calculator

class AppAndroidTest {

    @Test
    fun useAppContext() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("siarhei.luskanau.kmm.android", appContext.packageName)
    }

    @Test
    fun appAndroidTestSum() {
        assertEquals(3, Calculator.sum(1, 2))
    }
}
