package com.hamsoft.cleaning_services.ui.auth

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.hamsoft.cleaning_services.domain.models.auth.AuthResult
import com.hamsoft.cleaning_services.domain.repo.AuthRepository
import com.hamsoft.cleaning_services.domain.use_case.AuthUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class AuthenticationViewModel @Inject constructor(
    private val useCase: AuthUseCase,
    private val repository: AuthRepository,
): ViewModel() {

    var state by mutableStateOf(AuthState(AuthResult.Authenticating()))






    fun authenticate(){

    }

}