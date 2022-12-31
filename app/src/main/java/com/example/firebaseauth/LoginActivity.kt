package com.example.firebaseauth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.savedstate.SavedStateRegistryOwner
import com.example.firebaseauth.data.firebaseAuth.AuthRepositry
import com.example.firebaseauth.data.firebaseAuth.AuthRepositryImpl
import com.example.firebaseauth.data.firebaseAuth.AuthViewModel
import com.example.firebaseauth.utils.components
import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_login.*




@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private val authViewModel :AuthViewModel by viewModels()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)



        login_Button.setOnClickListener {
            val email = login_email.text.toString()
            val password = login_password.text.toString()
            authViewModel.loginUser(email , password)
            startActivity(Intent(this , HomeActivity::class.java))
            this.finish()
        }

        sign_up_nav.setOnClickListener {
            startActivity(Intent(this , SignUpActivity::class.java))
            this.finish()
        }





    }

}