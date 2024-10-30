package com.hamsoft.cleaning_services.domain.use_case

import com.hamsoft.cleaning_services.domain.models.auth.AuthResult
import com.hamsoft.cleaning_services.domain.repo.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class AuthUseCase @Inject constructor(
    private val repository: AuthRepository
){
    operator fun invoke(username: String, password: String): Flow<AuthResult<String>> = flow {
        try {
            emit(AuthResult.Authenticating())
            repository.signIn(username,password)
            emit(AuthResult.Authorized("Login successful"))
        } catch(e: IOException) {
            emit(AuthResult.Unauthorized("wrong credentials"))
        }
    }
}

