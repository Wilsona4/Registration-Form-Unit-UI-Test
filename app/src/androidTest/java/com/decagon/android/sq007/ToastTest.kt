package com.decagon.android.sq007

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.closeSoftKeyboard
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class ToastTest {

    @Before
    fun setUp(){
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
    }

    /*Test if Toast is Displayed and Correct Message is Displayed*/
    @Test
    fun testToastDisplayed_toastMessage() {
        /*Input Data whilst omitting Last Name*/
        onView(withId(R.id.firstName)).perform(replaceText(MainActivityTest.FIRST_NAME))
        closeSoftKeyboard()
        onView(withId(R.id.emailAddress)).perform(replaceText(MainActivityTest.EMAIL))
        closeSoftKeyboard()
        onView(withId(R.id.phoneNumber)).perform(replaceText(MainActivityTest.PHONE))
        closeSoftKeyboard()
        Thread.sleep(250)
        /*Select Spinner Item*/
        onView(withId(R.id.spinner)).perform(click())
        onView(withText(MainActivityTest.SEX)).perform(click());
        /*Click Register Button*/
        onView(withId(R.id.btRegister)).perform(swipeUp(), click())

        /*Check if the toast displayed and the is message correct*/
        onView(withText(MainActivityTest.MESSAGE)).inRoot(ToastMatcher()).check(matches(isDisplayed()))

    }
}