package com.example.firebaseauth

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.firebaseauth.data.firebaseAuth.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_sign_up.*

@AndroidEntryPoint
class SignUpActivity : AppCompatActivity() {

    private val authViewModel : AuthViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)



        signup_Button.setOnClickListener {
            val email = signup_email.text.toString()
            val password = signup_password.text.toString()
            val name = signup_name.text.toString()
            authViewModel.signupUser(name,email , password)
            startActivity(Intent(this , HomeActivity::class.java))
            this.finish()
        }

        login_nav.setOnClickListener {
            startActivity(Intent(this , LoginActivity::class.java))
            this.finish()
        }
    }
}