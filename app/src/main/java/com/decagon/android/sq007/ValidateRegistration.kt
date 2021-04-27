package com.decagon.android.sq007

object ValidateRegistration {

    /*Function to validate Email*/
    fun validateEmail(email: String): Boolean {
        val pattern = "\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,6}".toRegex()
        return email.matches(pattern)
    }

    /*Function to Validate Phone Number*/
    fun validatePhoneNumber(phoneNumber: String): Boolean {
        val pattern = "^(\\+234|234|0)[789]\\d{9}".toRegex()
        return phoneNumber.matches(pattern)
    }

    /*Function to Validate Gender*/
    fun validateGender(gender: String): Boolean {
        return gender != "Select Gender"
    }
}