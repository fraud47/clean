package com.hamsoft.cleaning_services.data.auth.remote.response.auth

data class Token(
    val access: String,
    val accessTokenType: String,
    val expiresIn: Int,
    val refresh: String,
    val refreshExpiresIn: Long
)