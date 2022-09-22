package com.dp.compose_neostore.ui.features.splash

import android.os.Bundle
import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import com.dp.compose_neostore.base.compose.AppRoute
import com.dp.compose_neostore.base.compose.CreateComposeScreen
import com.dp.compose_neostore.ui.features.splash.composes.SplashText
import com.dp.compose_neostore.ui.theme.Primary2
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreen : CreateComposeScreen<SplashViewModel, SplashUIModel>() {

    private val animValue = 0.7f

    @Composable
    override fun getSurfaceBackGroundColor(): Color {
        return Primary2
    }

    override suspend fun onInitData(coroutineScope: CoroutineScope, args: Bundle?) {
        data.scaleValue = animValue
        delay(2000L)
        val loginRoute = AppRoute.LoginRoute.apply {
            routeArgs = Bundle().apply {
                putString("name", "Dinesh Parmar")
            }
        }
        navController.navigate(loginRoute.routeName) {
            popUpTo(AppRoute.SplashRoute.routeName) {
                inclusive = true
            }
        }

    }

    @Composable
    override fun DrawCompose() {

        val scale = remember {
            Animatable(data.scaleValue)
        }
        // AnimationEffect
        LaunchedEffect(key1 = true) {
            scale.animateTo(
                targetValue = animValue,
                animationSpec = tween(
                    durationMillis = 800,
                    easing = {
                        OvershootInterpolator(4f).getInterpolation(it)
                    })
            )
        }

        SplashText.Create(data = scale.value)
        /*val scaffoldState: ScaffoldState = rememberScaffoldState()
      LaunchedEffect(true){
          coroutineScope.launch {
              scaffoldState.snackbarHostState.showSnackbar(
                  message = "This is your message",
                  actionLabel = "Do something"
              )
          }
      }*/


    }
}