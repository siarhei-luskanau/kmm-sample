package siarhei.luskanau.kmm.shared

import com.jetbrains.kmm.shared.Calculator
import kotlin.test.assertEquals
import org.junit.Test

class SharedAndroidTest {

    @Test
    fun sharedAndroidTestSum() {
        assertEquals(3, Calculator.sum(1, 2))
    }
}
