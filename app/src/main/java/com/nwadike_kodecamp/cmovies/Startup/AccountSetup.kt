package com.nwadike_kodecamp.cmovies.Startup

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.nwadike_kodecamp.cmovies.MainActivity
import com.nwadike_kodecamp.cmovies.R
import com.nwadike_kodecamp.cmovies.databinding.AccountSetupActivityBinding

class AccountSetup : AppCompatActivity() {

    lateinit var binding: AccountSetupActivityBinding;
    lateinit var userFullName: String;
    lateinit var submitDetails: MaterialButton;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AccountSetupActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initializeUIElements()

    }

    private fun initializeUIElements() {
        submitDetails = binding.sumbitDetails;

        submitDetails.setOnClickListener {
            userFullName = binding.fullName.text.toString()
            if (userFullName.isEmpty()) {
                Toast.makeText(this, getString(R.string.fullNameErrorMsg), Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            var intent: Intent = Intent(this, MainActivity::class.java)
            intent.putExtra("userFullName", userFullName)
            startActivity(intent)

        }

    }

}