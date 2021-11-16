package siarhei.luskanau.kmm.shared

import kotlin.test.Test
import kotlin.test.assertEquals

class SharedAndroidTest {

    @Test
    fun sharedAndroidTestSum() {
        assertEquals(3, Calculator.sum(1, 2))
    }
}
