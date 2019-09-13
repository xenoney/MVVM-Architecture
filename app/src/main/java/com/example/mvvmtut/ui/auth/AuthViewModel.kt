package com.example.mvvmtut.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.example.mvvmtut.data.respositories.UserRepository
import com.example.mvvmtut.util.ApiException
import com.example.mvvmtut.util.Coroutines

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

        Coroutines.main{
            try {
                val authResponse = UserRepository().userLogin(email!!, password!!)

                authResponse.user?.let {
                    authListener?.onSuccess(it)
                    return@main
                }

                authListener?.onFailure(authResponse.message!!)
            }catch (e: ApiException){
                authListener?.onFailure(e.message!!)
            }

        }
    }

}