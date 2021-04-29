package com.jetbrains.kmm.shared

import kotlin.test.Test
import kotlin.test.assertEquals
import siarhei.luskanau.kmm.shared.ResourceReader

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
