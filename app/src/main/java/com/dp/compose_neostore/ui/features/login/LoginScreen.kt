package com.dp.compose_neostore.ui.features.login

import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.dp.compose_neostore.base.CreateComposeScreen
import com.dp.compose_neostore.ui.showToast
import kotlinx.coroutines.CoroutineScope

class LoginScreen : CreateComposeScreen<LoginViewModel, LoginUIModel>() {

    @Composable
    override fun getSurfaceBackGroundColor(): Color {
        return Color.White
    }

    override suspend fun onInitData(coroutineScope: CoroutineScope,args: Bundle?) {
        navController.context.showToast("On Login Screen ${args?.getString("name")}")
    }

    @Composable
    override fun DrawCompose() {

    }
}