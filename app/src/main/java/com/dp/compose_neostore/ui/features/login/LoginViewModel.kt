package com.dp.compose_neostore.ui.features.login

import com.dp.compose_neostore.base.BaseViewModel
import com.dp.neostore_domain.params.LoginParams
import com.dp.neostore_domain.usecases.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val loginUseCase: LoginUseCase) : BaseViewModel() {

    private val _events = MutableSharedFlow<LoginEvents>()
    val events = _events.asSharedFlow()

    fun login(username: String, password: String) {
        executeUseCaseResult({
            val params = LoginParams(username, password)
            loginUseCase.buildUseCase(params)
        }, {
            _events.emitEventData(LoginEvents.OnLoginSuccess(it))
        }, {
            _events.emitEventData(LoginEvents.OnLoginFailed(it))

        })
    }


}