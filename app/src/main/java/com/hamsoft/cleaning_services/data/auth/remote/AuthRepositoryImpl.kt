package com.hamsoft.cleaning_services.data.auth.remote

import android.content.SharedPreferences
import com.hamsoft.cleaning_services.data.auth.remote.request.LoginRequest
import com.hamsoft.cleaning_services.data.auth.remote.request.RefreshToken
import com.hamsoft.cleaning_services.domain.models.auth.AuthResult
import com.hamsoft.cleaning_services.domain.repo.AuthRepository
import retrofit2.HttpException

class AuthRepositoryImpl(
    private val api: BaseApi,
    private val prefs: SharedPreferences
): AuthRepository {

    override suspend fun signUp(username: String, password: String): AuthResult<Unit> {
        return try {
            api.signUp(
                request = LoginRequest(
                    username = username,
                    password = password
                )
            )
            signIn(username, password)
        } catch(e: HttpException) {
            if(e.code() == 401) {
                AuthResult.Unauthorized()
            } else {
                AuthResult.UnknownError()
            }
        } catch (e: Exception) {
            AuthResult.UnknownError()
        }
    }

    override suspend fun signIn(username: String, password: String): AuthResult<Unit> {
        return try {
            val response = api.signIn(
                request = LoginRequest(
                    username = username,
                    password = password
                )
            )
            prefs.edit()
                .putString("jwt", response.body.token.access)
                .putString("refresh", response.body.token.refresh)
                .apply()
            AuthResult.Authorized()
        } catch(e: HttpException) {
            if(e.code() == 401) {
                AuthResult.Unauthorized()
            } else {
                AuthResult.UnknownError()
            }
        } catch (e: Exception) {
            AuthResult.UnknownError()
        }
    }

    override suspend fun authenticate(): AuthResult<Unit> {
        return try {
            val token = prefs.getString("refresh", null) ?: return AuthResult.Unauthorized()
            api.authenticate(RefreshToken(token))
            AuthResult.Authorized()
        } catch(e: HttpException) {
            if(e.code() == 401) {
                AuthResult.Unauthorized()
            } else {
                AuthResult.UnknownError()
            }
        } catch (e: Exception) {
            AuthResult.UnknownError()
        }
    }
}