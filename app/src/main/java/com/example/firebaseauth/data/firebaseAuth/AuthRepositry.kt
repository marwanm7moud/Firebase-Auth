package com.example.firebaseauth.data.firebaseAuth

import com.example.firebaseauth.data.Resource
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

interface AuthRepositry {

    val currentUser :FirebaseUser?
    suspend fun login(email:String , password:String):Resource<FirebaseUser>
    suspend fun signup(name:String,email:String , password:String):Resource<FirebaseUser>
    fun logout()

}