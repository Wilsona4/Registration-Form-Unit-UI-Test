package com.decagon.android.sq007

import junit.framework.TestCase
import org.junit.Test

class ValidateRegistrationTest : TestCase() {

    /*Set Up Mock Input Data*/
    private val emailTrue: String = "johndoe@gmail.com"
    private val emailFalse: String = "johndoe@com"

    private val numberFalse: String = "0813553775"
    private val numberTrue: String = "+2348492015369"

    private val genderTrue: String = "Male"
    private val genderFalse: String = "Select Gender"

    /*Test Validate Email Function with Correct Mail*/
    @Test
    fun testValidateEmail_isTrue() {
        val result = ValidateRegistration.validateEmail(emailTrue)
        assertTrue(result)
    }

    /*Test Validate Email Function with Wrong Email*/
    @Test
    fun testValidateEmail_isFalse() {
        val result = ValidateRegistration.validateEmail(emailFalse)
        assertFalse(result)
    }

    /*Test Validate Phone Number Function with a Correct Number*/
    @Test
    fun testValidatePhoneNumber_isTrue() {
        val result = ValidateRegistration.validatePhoneNumber(numberTrue)
        assertTrue(result)
    }

    /*Test Validate Phone Number Function with a Wrong Number*/
    @Test
    fun testValidatePhoneNumber_isFalse() {
        val result = ValidateRegistration.validatePhoneNumber(numberFalse)
        assertFalse(result)
    }

    /*Test Validate Gender Function with a Correct Gender*/
    @Test
    fun testValidateGender_isTrue() {
        val result = ValidateRegistration.validateGender(genderTrue)
        assertTrue(result)
    }

    /*Test Validate Gender Function with a Wrong Gender*/
    @Test
    fun testValidateGender_isFalse() {
        val result = ValidateRegistration.validateGender(genderFalse)
        assertFalse(result)
    }
}