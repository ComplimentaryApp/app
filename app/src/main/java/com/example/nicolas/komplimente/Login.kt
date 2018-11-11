package com.example.nicolas.komplimente

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup

class Login : AppCompatActivity() {


    private lateinit var loginButt: Button
    private lateinit var signupButt: Button
    private lateinit var username: EditText
    private lateinit var password: EditText
    private lateinit var email: EditText
    private lateinit var firstName: EditText
    private lateinit var lastName: EditText
    private lateinit var dob: EditText
    private lateinit var gender: RadioGroup

    private var signingUp = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val prefs = PreferenceManager.getDefaultSharedPreferences(applicationContext)
        if (prefs.contains("token")) return progress()

        setContentView(R.layout.activity_login)
        loginButt = findViewById(R.id.loginButt)
        username = findViewById(R.id.usernameInput)
        password = findViewById(R.id.passwordInput)
        email = findViewById(R.id.emailInput)
        firstName = findViewById(R.id.firstName)
        lastName = findViewById(R.id.lastName)
        dob = findViewById(R.id.dobInput)
        gender = findViewById(R.id.genderRadio)
        signupButt = findViewById(R.id.signupButt)

        loginButt.setOnClickListener {
            if (signingUp) {
                val chosenGender: RadioButton = gender.findViewById(gender.checkedRadioButtonId)
                DBHandler.createUser(username.text.toString(), email.text.toString(),
                        firstName.text.toString(), lastName.text.toString(), dob.text.toString(),
                        chosenGender.text.first()) { success ->
                    if (success) login()
                }
            } else {
                login()
            }
        }
        val signupFields = listOf(email, firstName, lastName, dob, gender)
        signupButt.setOnClickListener {
            if (signingUp) {
                signupButt.text = getString(R.string.signup)
                loginButt.text = getString(R.string.login)
                signupFields.forEach { it.visibility = View.GONE }
                signingUp = false
            } else {
                signupButt.text = getString(R.string.login)
                loginButt.text = getString(R.string.signup)
                signupFields.forEach { it.visibility = View.VISIBLE }

                signingUp = true
            }
        }



    }

    private fun login() {
        DBHandler.login(username.text.toString(), password.text.toString()) { token ->
            if (token == null) {
                username.setText("")
                return@login
            }
            val prefs = PreferenceManager.getDefaultSharedPreferences(applicationContext)
            val editor = prefs.edit()
            editor.putString("token", token)
            editor.apply()

            progress()
        }
    }

    private fun progress() {
        runOnUiThread {
            val intent = Intent(this, MainActivity::class.java)
            //val name = username.text.toString()
            startActivity(intent)
        }
    }
}
