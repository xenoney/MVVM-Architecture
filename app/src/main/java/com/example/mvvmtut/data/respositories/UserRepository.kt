package com.example.mvvmtut.data.respositories

import com.example.mvvmtut.data.network.MyAPI
import com.example.mvvmtut.data.network.responses.AuthResponse
import retrofit2.Response

class UserRepository {

    suspend fun userLogin(email: String, password: String) : Response<AuthResponse> {

        return MyAPI().userLogin(email, password)

    }

}