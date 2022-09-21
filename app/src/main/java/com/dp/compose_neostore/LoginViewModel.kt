package com.dp.compose_neostore

import com.dp.compose_neostore.base.BaseViewModel
import com.dp.nestore_domain.params.LoginParams
import com.dp.nestore_domain.usecases.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val loginUseCase: LoginUseCase) : BaseViewModel() {


    fun login(username: String, password: String) {
        executeUseCaseResult({
            val params = LoginParams(username, password)
            loginUseCase.buildUseCase(params)
        }, {

        }, {

        })
    }


}