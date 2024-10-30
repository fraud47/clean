package com.hamsoft.cleaning_services.data.auth.remote.response.auth

data class AuthTokenResponse(
    val roles: List<Role>,
    val token: Token
)