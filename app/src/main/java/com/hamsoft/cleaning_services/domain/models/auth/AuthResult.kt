package com.hamsoft.cleaning_services.domain.models.auth

sealed class AuthResult<T>(val data: T? = null){
    class Authorized<T>(data: T? = null): AuthResult<T>(data)
    class Unauthorized<T>(error: T? = null): AuthResult<T>()
    class UnknownError<T>(error: T? = null): AuthResult<T>()
    class Authenticating<T>(): AuthResult<T>()
}