package siarhei.luskanau.kmm.shared

import platform.Foundation.NSBundle
import kotlin.test.Test
import kotlin.test.assertEquals

class GreetingTest {

    @Test
    fun testExample() {
        val bundle = NSBundle.mainBundle()
        assertEquals(
            expected = "{\n" +
                "  \"name\": \"kotlinx.serialization\",\n" +
                "  \"language\": \"${bundle}\"\n" +
                "}\n",
            actual = ResourceReader(bundle = bundle).readResource("data.json")
        )
    }
}
