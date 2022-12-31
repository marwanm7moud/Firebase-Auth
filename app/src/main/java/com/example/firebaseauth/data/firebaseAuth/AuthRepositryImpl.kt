package com.example.firebaseauth.data.firebaseAuth

import com.example.firebaseauth.data.Resource
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest
import javax.inject.Inject

class AuthRepositryImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth
)
    : AuthRepositry {
    override val currentUser: FirebaseUser?
        get() = firebaseAuth.currentUser

    override suspend fun login(email: String, password: String): Resource<FirebaseUser> {
        return try {
            val result =firebaseAuth.signInWithEmailAndPassword(email , password).await()
            Resource.Success(result.user!!)
        }catch (e:Exception){
            Resource.Failure(e)
        }
    }

    override suspend fun signup(name:String,email: String, password: String): Resource<FirebaseUser> {
        return try {
            val result =firebaseAuth.createUserWithEmailAndPassword(email , password).await()
            result.user?.updateProfile(UserProfileChangeRequest.Builder().setDisplayName(name).build())?.await()
            Resource.Success(result.user!!)
        }catch (e:Exception){
            Resource.Failure(e)
        }
    }

    override fun logout() {
        firebaseAuth.signOut()
    }
}