package com.decagon.android.sq007

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.decagon.android.sq007.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private lateinit var binding: ActivityMainBinding

    private lateinit var spinner: Spinner
    private lateinit var regButton: Button
    private lateinit var etFirstName: TextInputEditText
    private lateinit var etLastName: TextInputEditText
    private lateinit var etEmail: TextInputEditText
    private lateinit var etPhoneNumber: TextInputEditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*Initialize Views*/
        spinner = binding.spinner
        etFirstName = binding.firstName
        etLastName = binding.lastName
        etEmail = binding.emailAddress
        etPhoneNumber = binding.phoneNumber
        regButton = binding.btRegister

        /*Listen for Selected Spinner Item*/
        spinner.onItemSelectedListener = this

        /*Validate Email and Phone Number in Runtime*/
        validateEmail()
        validatePhoneNumber()

        regButton.setOnClickListener {

            /*Initialize User Inputs*/
            val firstName = etFirstName.text.toString()
            val lastName = etLastName.text.toString()
            val email = etEmail.text.toString()
            val phoneNumber = etPhoneNumber.text.toString()
            val sex = spinner.selectedItem.toString()

            /*Validate All Fields*/
            if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || phoneNumber.isEmpty() || sex.isEmpty()) {
                Toast.makeText(this, "All Fields are Required", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            } else if (!ValidateRegistration.validateEmail(email)) {
                etEmail.error = "Invalid Email"
                Toast.makeText(this, "Invalid Email", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            } else if (!ValidateRegistration.validatePhoneNumber(phoneNumber)) {
                etPhoneNumber.error = "Invalid Phone Number"
                Toast.makeText(this, "Enter Nigerian Number", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            } else if (!ValidateRegistration.validateGender(sex)) {
                Toast.makeText(this, "Select Gender", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            } else {
                /*Create Bundle to Store Data*/
                val bundle = Bundle()
                bundle.apply {
                    putString("FIRST_NAME", firstName)
                    putString("LAST_NAME", lastName)
                    putString("EMAIL", email)
                    putString("PHONE_NUMBER", phoneNumber)
                    putString("SEX", sex)
                }
                /*Navigate to Profile Activity*/
                val intent = Intent(this, ProfileActivity::class.java).apply {
                    putExtras(bundle)
                }

                startActivity(intent)
            }
        }


        /*Set Up Spinner ArrayAdapter using the string array and a default spinner layout*/
        ArrayAdapter.createFromResource(
            this,
            R.array.Sex,
            android.R.layout.simple_spinner_item
        ).also {
            it.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = it
        }
    }

    /*Function to Validate Email as Input Changes*/
    private fun validateEmail() {

        etEmail.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (ValidateRegistration.validateEmail(etEmail.text.toString())) {
                    regButton.isEnabled = true
                } else {
                    etEmail.error = "Invalid Email"
                }
            }

            override fun afterTextChanged(s: Editable?) {
                if (ValidateRegistration.validateEmail(etEmail.text.toString())) {
                    regButton.isEnabled = true
                } else {
                    etEmail.error = "Invalid Email"
                }
            }

        })
    }

    /*Function to Validate Phone Number as Input Changes*/
    private fun validatePhoneNumber() {

        etPhoneNumber.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (ValidateRegistration.validatePhoneNumber(etPhoneNumber.text.toString())) {
                    regButton.isEnabled = true

                } else {
                    etPhoneNumber.error = "Invalid Phone Number"
                }
            }

            override fun afterTextChanged(s: Editable?) {
                if (ValidateRegistration.validatePhoneNumber(etPhoneNumber.text.toString())) {
                    regButton.isEnabled = true
                } else {
                    etPhoneNumber.error = "Invalid Phone Number"
                }
            }

        })
    }

    /*Get Selected Spinner Item*/
    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        parent?.getItemAtPosition(position)
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }


}