package com.hamsoft.cleaning_services.data.auth.remote.response

data class Response<T>(
    val body: T,
    val narration: String,
    val status: Int,
    val successful: Boolean
)