package com.dp.compose_neostore.ui.features.splash

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.graphics.Color
import com.dp.compose_neostore.base.CreateComposeScreen
import com.dp.compose_neostore.ui.showToast
import com.dp.compose_neostore.ui.theme.Primary2
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay

class SplashScreen : CreateComposeScreen<SplashViewModel,SplashUIModel>() {


    @Composable
    override fun getSurfaceBackGroundColor(): Color {
        return Primary2
    }

    override suspend fun onInitData(coroutineScope: CoroutineScope) {
        data.scaleValue = 0.7f
        delay(2000L)
        navController.context.showToast("navigate_ main_screen")

    }

    @Composable
    override fun DrawCompose() {

        val scale = remember {
            Animatable(data.scaleValue)
        }
        // AnimationEffect
        LaunchedEffect(key1 = true) {
            scale.animateTo(
                targetValue = 0.7f,
                animationSpec = tween(
                    durationMillis = 800,
                    easing = {
                        OvershootInterpolator(4f).getInterpolation(it)
                    })
            )
        }

        SplashText.Create(data = scale.value)

    }
}