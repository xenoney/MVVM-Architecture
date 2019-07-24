package com.example.mvvmtut.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel

class AuthViewModel : ViewModel() {

    var email: String? = null
    var password: String? = null

    var authListener: AuthListener? = null

    fun onLoginButtonClick(view: View){
        authListener?.onStarted()
        if(email.isNullOrEmpty() || password.isNullOrEmpty()){
            // Failure
            authListener?.onFailure("Invalid email or password")
            return
        }

        // Success
        authListener?.onSuccess()
    }
}