package com.hamsoft.cleaning_services.data.auth.remote

import com.hamsoft.cleaning_services.data.auth.remote.request.LoginRequest
import com.hamsoft.cleaning_services.data.auth.remote.request.RefreshToken
import com.hamsoft.cleaning_services.data.auth.remote.response.auth.AuthTokenResponse
import com.hamsoft.cleaning_services.data.auth.remote.response.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Url


interface BaseApi {

    @POST("public/users/")
    suspend fun signUp(
        @Body request: LoginRequest
    ):Response<AuthTokenResponse>

    @POST("public/users/")
    suspend fun signIn(
        @Body request: LoginRequest
    ): Response<AuthTokenResponse>


    @GET("public/users/refresh")
    suspend fun authenticate(
        @Body refreshToken: RefreshToken
    ):Response<AuthTokenResponse>
}