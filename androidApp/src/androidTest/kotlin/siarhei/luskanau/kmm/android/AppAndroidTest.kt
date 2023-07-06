package siarhei.luskanau.kmm.android

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.platform.app.InstrumentationRegistry
import com.karumi.shot.ScreenshotTest
import siarhei.luskanau.kmm.shared.Calculator
import kotlin.test.Test
import kotlin.test.assertEquals

class AppAndroidTest : ScreenshotTest {

    @Test
    fun useAppContext() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("siarhei.luskanau.kmm.android", appContext.packageName)
    }

    @Test
    fun appAndroidTestSum() {
        assertEquals(3, Calculator.sum(1, 2))
    }

    @Test
    fun rendersTheDefaultActivityState() {
        val scenario = ActivityScenario.launch(MainActivity::class.java)
        scenario.moveToState(Lifecycle.State.RESUMED)
        scenario.onActivity {
            compareScreenshot(
                activity = it,
                name = javaClass.simpleName,
            )
        }
    }
}
