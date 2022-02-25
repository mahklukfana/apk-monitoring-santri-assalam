package com.example.mhyneuq.core.data.source.remote.network

import com.example.mhyneuq.core.data.source.remote.request.LoginRequest
import com.example.mhyneuq.core.data.source.remote.request.RegisterRequest
import com.example.mhyneuq.core.data.source.remote.response.LoginResponse
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    /**
     * Auth
     */
    @POST("login")
    suspend fun login(
//        cara 1
        @Body login : LoginRequest
    ):Response<LoginResponse>

    @POST("register")
    suspend fun register(
        @Body data: RegisterRequest
    ):Response<LoginResponse>
}