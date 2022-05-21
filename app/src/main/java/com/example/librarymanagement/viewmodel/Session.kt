package com.example.librarymanagement.viewmodel

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences

class Session(context: Context) {
    private val prefs: SharedPreferences = context.getSharedPreferences("MySharedPref", MODE_PRIVATE)

    fun setUsername(username: String) {
        prefs.edit().putString("username", username).apply()
    }

    fun getusename(): String? {
        return prefs.getString("username", "")
    }

  //  init {
//        val sp = context.getSharedPreferences("MySharedPref", MODE_PRIVATE)
//        val ed = sp.edit()
//        ed.putInt("value", your_value)
//        ed.apply()
        // TODO Auto-generated constructor stub
 //   }
}