package com.example.firebaseauth.utils

import android.content.Context
import android.content.SharedPreferences

object components {

    val sharedpref = "sharedprefs"

    fun SharedprefUtils (context: Context , response:String){
        val sharedPref: SharedPreferences = context.getSharedPreferences(sharedpref,Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putString("login", response)
        editor.commit()
    }
    fun getSharedprefUtils (context: Context):String?{
        val sharedPref: SharedPreferences = context.getSharedPreferences(sharedpref,Context.MODE_PRIVATE)
        return sharedPref.getString("login", "")
    }


}