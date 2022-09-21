package com.dp.compose_neostore

import androidx.lifecycle.ViewModel
import com.dp.nestore_domain.usecases.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(val loginUseCase: LoginUseCase) : ViewModel()