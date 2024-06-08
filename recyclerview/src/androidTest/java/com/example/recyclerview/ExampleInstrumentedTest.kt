<<<<<<<< Updated upstream:CustomCalendar/app/src/androidTest/java/com/example/customcalendar/ExampleInstrumentedTest.kt
package com.example.customcalendar
========
package com.example.recyclerview
>>>>>>>> Stashed changes:recyclerview/src/androidTest/java/com/example/recyclerview/ExampleInstrumentedTest.kt

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
<<<<<<<< Updated upstream:CustomCalendar/app/src/androidTest/java/com/example/customcalendar/ExampleInstrumentedTest.kt
        assertEquals("com.example.customcalendar", appContext.packageName)
========
        assertEquals("com.example.recyclerview", appContext.packageName)
>>>>>>>> Stashed changes:recyclerview/src/androidTest/java/com/example/recyclerview/ExampleInstrumentedTest.kt
    }
}