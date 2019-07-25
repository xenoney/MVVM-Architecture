package com.example.mvvmtut.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.example.mvvmtut.data.respositories.UserRepository

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

        val loginResponse = UserRepository().userLogin(email!!, password!!)
        // Success
        authListener?.onSuccess(loginResponse)

    }

}