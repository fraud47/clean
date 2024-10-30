package com.hamsoft.cleaning_services.domain.repo

import com.hamsoft.cleaning_services.domain.models.auth.AuthResult

interface AuthRepository {
    suspend fun signUp(username: String, password: String): AuthResult<Unit>
    suspend fun signIn(username: String, password: String): AuthResult<Unit>
    suspend fun authenticate(): AuthResult<Unit>
}