package siarhei.luskanau.kmm.shared

import kotlin.test.Test
import kotlin.test.assertEquals

class GreetingTest {

    @Test
    fun testExample() {
        assertEquals(
            expected = "{\n" +
                "  \"name\": \"kotlinx.serialization\",\n" +
                "  \"language\": \"Kotlin\"\n" +
                "}\n",
            actual = ResourceReader().readResource("data.json"),
        )
    }
}
