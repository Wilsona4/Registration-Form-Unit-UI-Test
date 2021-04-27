package com.decagon.android.sq007

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class ProfileActivityTest {
    @get:Rule
    val activityRule: ActivityScenarioRule<ProfileActivity> =
        ActivityScenarioRule(ProfileActivity::class.java)

    /*Test if Profile Activity is Visible*/
    @Test
    fun testActivityInView() {
        onView(ViewMatchers.withId(R.id.activity_profile)).check(matches(isDisplayed()))
    }

    /*Test EditText Visibility*/
    @Test
    fun testFirstNameEditTextInView() {
        onView(ViewMatchers.withId(R.id.tvName)).check(matches(isDisplayed()))
    }

}