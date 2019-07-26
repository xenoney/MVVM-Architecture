package com.example.mvvmtut.data.network.responses

import com.example.mvvmtut.data.db.entities.User

data class AuthResponse(
    val isSuccessful : Boolean?,
    val message : String?,
    val user : User?
)