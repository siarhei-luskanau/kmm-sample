package siarhei.luskanau.kmm.android

import kotlin.test.Test
import kotlin.test.assertEquals
import siarhei.luskanau.kmm.shared.Calculator

class AppUnitTest {

    @Test
    fun appUnitTestSum() {
        assertEquals(3, Calculator.sum(1, 2))
    }
}
