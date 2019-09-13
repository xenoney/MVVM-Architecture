package com.example.mvvmtut.data.respositories

import com.example.mvvmtut.data.network.MyAPI
import com.example.mvvmtut.data.network.responses.AuthResponse
import com.example.mvvmtut.data.network.responses.SafeApiRequest
import retrofit2.Response

class UserRepository : SafeApiRequest(){

    suspend fun userLogin(email: String, password: String) : AuthResponse {

        return apiRequest{MyAPI().userLogin(email, password)}

    }

}