package com.dp.compose_neostore.base.compose

import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.dp.compose_neostore.ui.features.login.LoginScreen
import com.dp.compose_neostore.ui.features.login.LoginUIModel
import com.dp.compose_neostore.ui.features.login.LoginViewModel
import com.dp.compose_neostore.ui.features.splash.SplashScreen
import com.dp.compose_neostore.ui.features.splash.SplashUIModel
import com.dp.compose_neostore.ui.features.splash.SplashViewModel

sealed class AppRoute<VM : ViewModel, Data : java.io.Serializable>(
    val routeName: String,
    val createComposeScreen: CreateComposeScreen<VM, Data>,
) {

    var routeArgs: Bundle? = null
    object SplashRoute : AppRoute<SplashViewModel, SplashUIModel>("SplashRoute", SplashScreen())
    object LoginRoute : AppRoute<LoginViewModel, LoginUIModel>("LoginRoute",
        LoginScreen())
}


@Composable
internal fun NavHostController.NavigateAppRoute(startAppRoute: AppRoute<*, *>) {
    val navController = this
    NavHost(navController, startDestination = startAppRoute.routeName) {
        composable(AppRoute.SplashRoute.routeName) {
            AppRoute.SplashRoute.createComposeScreen.Screen(navController, hiltViewModel(),
                SplashUIModel(), AppRoute.LoginRoute.routeArgs)
        }
        composable(AppRoute.LoginRoute.routeName) {
            AppRoute.LoginRoute.createComposeScreen.Screen(navController, hiltViewModel(),
                LoginUIModel(), AppRoute.LoginRoute.routeArgs)
        }
    }
}