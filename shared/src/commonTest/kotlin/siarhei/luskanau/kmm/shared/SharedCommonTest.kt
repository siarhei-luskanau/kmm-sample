package siarhei.luskanau.kmm.shared

import com.jetbrains.kmm.shared.Calculator
import kotlin.test.Test
import kotlin.test.assertEquals

class SharedCommonTest {

    @Test
    fun sharedCommonTestSum() {
        assertEquals(3, Calculator.sum(1, 2))
    }
}
