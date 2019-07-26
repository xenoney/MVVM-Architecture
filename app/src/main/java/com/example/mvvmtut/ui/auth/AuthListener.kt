package com.example.mvvmtut.ui.auth

import com.example.mvvmtut.data.db.entities.User

interface AuthListener {
    fun onStarted()
    fun onSuccess(user: User)
    fun onFailure(message: String)
}