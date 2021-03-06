package com.decagon.android.sq007

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.closeSoftKeyboard
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {

    companion object {
        const val FIRST_NAME = "John"
        const val LAST_NAME = "Doe"
        const val EMAIL = "johndoe@gmail.com"
        const val PHONE = "+2348154478844"
        const val SEX = "Male"
        const val MESSAGE = "All Fields are Required"
    }

    @get:Rule
    val activityRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    /*Test if Main Activity is Visible*/
    @Test
    fun testActivityInView() {
        onView(withId(R.id.activity_main)).check(matches(isDisplayed()))
    }

    /*Test EditText Visibility*/
    @Test
    fun testFirstNameEditTextInView() {
        onView(withId(R.id.firstName)).check(matches(isDisplayed()))
    }

    /*Test Button Visibility*/
    @Test
    fun testRegisterButtonInView() {
        onView(withId(R.id.btRegister)).check(matches(isDisplayed()))
    }

    /*Test Spinner Visibility*/
    @Test
    fun testSpinnerIsDisplayed() {
        onView(withId(R.id.spinner)).check(matches(isDisplayed()))
    }

    /*Navigation Tests*/

    /*Test Navigation to Profile Activity*/
    @Test
    fun testNavigationToProfileActivity() {
        /*Input Data*/
        onView(withId(R.id.firstName)).perform(replaceText(FIRST_NAME))
        closeSoftKeyboard()
        onView(withId(R.id.lastName)).perform(replaceText(LAST_NAME))
        closeSoftKeyboard()
        onView(withId(R.id.emailAddress)).perform(replaceText(EMAIL))
        closeSoftKeyboard()
        onView(withId(R.id.phoneNumber)).perform(replaceText(PHONE))
        closeSoftKeyboard()
        Thread.sleep(250)
        /*Select Spinner Item*/
        onView(withId(R.id.spinner)).perform(click())
        onView(withText(SEX)).perform(click());
        /*Click Register Button*/
        onView(withId(R.id.btRegister)).perform(swipeUp(), click())
        /*Check if Profile Activity is Displayed*/
        onView(withId(R.id.activity_profile)).check(matches(isDisplayed()))
    }

    /*Test Navigation to and fro Profile Activity*/
    @Test
    fun testNavigationFromProfileActivity_BackPressedToMainActivity() {
        /*Input Data*/
        onView(withId(R.id.firstName)).perform(replaceText(FIRST_NAME))
        closeSoftKeyboard()
        onView(withId(R.id.lastName)).perform(replaceText(LAST_NAME))
        closeSoftKeyboard()
        onView(withId(R.id.emailAddress)).perform(replaceText(EMAIL))
        closeSoftKeyboard()
        onView(withId(R.id.phoneNumber)).perform(replaceText(PHONE))
        closeSoftKeyboard()
        Thread.sleep(250)
        /*Select Spinner Item*/
        onView(withId(R.id.spinner)).perform(click())
        onView(withText(SEX)).perform(click());
        /*Click Register Button*/
        onView(withId(R.id.btRegister)).perform(swipeUp(), click())
        /*Check if Profile Activity is Displayed*/
        onView(withId(R.id.activity_profile)).check(matches(isDisplayed()))
        /*Back Pressed*/
        Espresso.pressBack()
        onView(withId(R.id.activity_main)).check(matches(isDisplayed()))
    }

    /*Intent Put-Extra Tests*/
    @Test
    fun testMainActivityDataSent_vsProfileActivityDataDisplayed() {
        /*Input Data*/
        onView(withId(R.id.firstName)).perform(replaceText(FIRST_NAME))
        closeSoftKeyboard()
        onView(withId(R.id.lastName)).perform(replaceText(LAST_NAME))
        closeSoftKeyboard()
        onView(withId(R.id.emailAddress)).perform(replaceText(EMAIL))
        closeSoftKeyboard()
        onView(withId(R.id.phoneNumber)).perform(replaceText(PHONE))
        closeSoftKeyboard()
        Thread.sleep(250)
        /*Select Spinner Item*/
        onView(withId(R.id.spinner)).perform(click())
        onView(withText(SEX)).perform(click());
        /*Click Register Button*/
        onView(withId(R.id.btRegister)).perform(swipeUp(), click())
        /*Check if Profile Activity is Displayed*/
        onView(withId(R.id.activity_profile)).check(matches(isDisplayed()))
        /*Check if Data Sent from Main Activity matches Data Displayed in Profile*/
        onView(withId(R.id.tvEmail)).check(matches(withText(EMAIL)))
    }
}