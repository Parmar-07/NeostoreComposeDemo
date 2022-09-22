package com.dp.compose_neostore.ui.features.splash

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import com.dp.compose_neostore.base.BaseViewModel
import com.dp.compose_neostore.base.CreateComposeScreen
import com.dp.compose_neostore.ui.showToast
import kotlinx.coroutines.delay
import javax.inject.Inject

class SplashScreen:
    CreateComposeScreen<SplashViewModel>() {


    @Composable
    override fun Create(navController: NavController, vm: SplashViewModel) {

        val scale = remember {
            androidx.compose.animation.core.Animatable(0f)
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
            delay(3000L)
            navController.context.showToast("navigate_ main_screen")
            //navController.navigate("main_screen")
        }
        SplashText.Create(data = scale.value)

    }
}