package com.decagon.android.sq007

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.decagon.android.sq007.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*Initialize Views*/
        val tvName = binding.tvName
        val tvEmail = binding.tvEmail
        val tvPhoneNumber = binding.tvNumber
        val tvSex = binding.tvSex

        /*Get Bundle*/
        val bundle = intent.extras
        val firstName: String? = bundle?.getString("FIRST_NAME")
        val lastName: String? = bundle?.getString("LAST_NAME")
        val email: String? = bundle?.getString("EMAIL")
        val phoneNumber: String? = bundle?.getString("PHONE_NUMBER")
        val sex: String? = bundle?.getString("SEX")

        /*Set View Contents*/
        tvName.text = "$firstName $lastName"
        tvEmail.text = email
        tvPhoneNumber.text = phoneNumber
        tvSex.text = sex

    }
}