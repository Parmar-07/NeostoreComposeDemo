package com.dp.compose_neostore.ui.features.login

import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.dp.compose_neostore.base.compose.CreateComposeScreen
import com.dp.compose_neostore.ui.showToast
import kotlinx.coroutines.CoroutineScope

class LoginScreen : CreateComposeScreen<LoginViewModel, LoginUIModel>() {

    @Composable
    override fun getSurfaceBackGroundColor(): Color {
        return Color.White
    }

    override suspend fun onObserveEvents(coroutineScope: CoroutineScope) {
        viewModel.events.collect { event ->
            when (event) {
                is LoginEvents.OnLoginSuccess -> {
                    navController.context.showToast(event.loginDataModel.userMsg)
                    //showSnackBarMessage(event.loginDataModel.userMsg)
                }
                is LoginEvents.OnLoginFailed -> {
                    navController.context.showToast(event.error)

                }
            }
        }
    }

    override suspend fun onInitData(coroutineScope: CoroutineScope, args: Bundle?) {
//        navController.context.showToast("On Login Screen ${args?.getString("name")}")
        // doLogin()
    }

    @Composable
    override fun DrawCompose() {
        doLogin()
    }


    private fun doLogin() {
        viewModel.login("abc22@gmail.com", "test123")

    }

}