package com.example.firebaseauth.data.firebaseAuth

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firebaseauth.data.Resource
import com.example.firebaseauth.utils.components
import com.google.android.material.internal.ContextUtils.getActivity
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class AuthViewModel  @Inject constructor(
    private val repository: AuthRepositryImpl,
):ViewModel() {


    private val _loginFlow = MutableStateFlow<Resource<FirebaseUser>?>(null)
    val loginFlow: StateFlow<Resource<FirebaseUser>?> = _loginFlow

    private val _signupFlow = MutableStateFlow<Resource<FirebaseUser>?>(null)
    val signupFlow: StateFlow<Resource<FirebaseUser>?> = _signupFlow

    val currentUser: FirebaseUser?
        get() = repository.currentUser

    init {
        if (repository.currentUser != null) {
            _loginFlow.value = Resource.Success(repository.currentUser!!)
        }
    }


    fun loginUser(email:String , password:String) = viewModelScope.launch{
        _loginFlow.value = Resource.Loading
        val result:Resource<FirebaseUser> = repository.login(email , password)
        _loginFlow.value = result
    }
    fun signupUser(name:String,email:String , password:String)=viewModelScope.launch{
        _signupFlow.value = Resource.Loading
        val result = repository.signup(name,email , password)
        _signupFlow.value = result

    }
    fun signoutUser()=viewModelScope.launch{
        repository.logout()
        _signupFlow.value = null
        _loginFlow.value = null

    }




}

