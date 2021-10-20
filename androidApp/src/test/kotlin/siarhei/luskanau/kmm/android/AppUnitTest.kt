package siarhei.luskanau.kmm.android

import com.jetbrains.kmm.shared.Calculator
import kotlin.test.Test
import kotlin.test.assertEquals

class AppUnitTest {

    @Test
    fun appUnitTestSum() {
        assertEquals(3, Calculator.sum(1, 2))
    }
}
