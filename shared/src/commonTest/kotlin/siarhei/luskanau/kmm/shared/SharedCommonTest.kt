package siarhei.luskanau.kmm.shared

import kotlin.test.Test
import kotlin.test.assertEquals

class SharedCommonTest {

    @Test
    fun sharedCommonTestSum() {
        assertEquals(3, Calculator.sum(1, 2))
    }
}
