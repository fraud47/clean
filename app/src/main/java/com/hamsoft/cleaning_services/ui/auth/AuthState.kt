package com.hamsoft.cleaning_services.ui.auth

import com.hamsoft.cleaning_services.domain.models.auth.AuthResult

data class AuthState(
    val authResult: AuthResult<String>,
)
