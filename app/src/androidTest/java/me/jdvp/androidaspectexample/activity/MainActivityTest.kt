package me.jdvp.androidaspectexample.activity

import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import junit.framework.TestCase.assertEquals
import me.jdvp.androidaspectexample.R
import me.jdvp.androidaspectexample.utility.Logger
import org.junit.After
import org.junit.Before
import org.junit.Test

/**
 * Tests added just to make sure that aspects are weaved correctly without having to actually
 * run the app and check the logs manually.
 */
class MainActivityTest {
    private lateinit var loggerListener: Logger.LoggerListener
    private val loggedItems = mutableListOf<String>()

    @Before
    fun setup() {
        loggerListener = Logger.LoggerListener { loggedItem ->
            loggedItems.add(loggedItem)
        }
        Logger.registerLoggerListener(loggerListener)
    }

    @After
    fun tearDown() {
        loggedItems.clear()
        Logger.clearListeners()
    }

    /**
     * Ensures that the action actually coded in MainActivity occurs but also
     * that the logging code was actually injected and called as expected for
     * the button 1 click.
     */
    @Test
    fun test_buttonClick_1() {
        launchActivity<MainActivity>()
        onView(withId(R.id.button_1)).perform(click())

        verifyTextDisplayed("Button 1 clicked")
        assertEquals(listOf(
            "onCreate called in MainActivity",
            "Button 1 clicked"
        ), loggedItems)
    }

    /**
     * Ensures that the action actually coded in MainActivity occurs but also
     * that the logging code was actually injected and called as expected for
     * the button 2 click.
     */
    @Test
    fun test_buttonClick_2() {
        launchActivity<MainActivity>()
        onView(withId(R.id.button_2)).perform(click())

        verifyTextDisplayed("Button 2 clicked")
        assertEquals(listOf(
            "onCreate called in MainActivity",
            "Button 2 clicked"
        ), loggedItems)
    }

    private fun verifyTextDisplayed(text: String) {
        onView(withText(text))
            .check(matches(isDisplayed()))
    }
}