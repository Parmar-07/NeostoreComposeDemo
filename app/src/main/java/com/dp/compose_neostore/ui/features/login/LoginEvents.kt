package com.dp.compose_neostore.ui.features.login

import com.dp.neostore_domain.data.LoginDataModel

sealed class LoginEvents {

    data class OnLoginSuccess(val loginDataModel: LoginDataModel):LoginEvents()
    data class OnLoginFailed(val error:String):LoginEvents()

}