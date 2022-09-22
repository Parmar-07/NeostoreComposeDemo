package com.dp.compose_neostore.utils

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.dp.compose_neostore.base.BaseViewModel
import com.dp.compose_neostore.base.CreateComposeScreen
import com.dp.compose_neostore.ui.features.splash.SplashScreen
import com.dp.compose_neostore.ui.features.splash.SplashViewModel

sealed class AppRoute<VM : ViewModel>(
    val routeName: String,
    val createComposeScreen: CreateComposeScreen<VM>,
) {
    object SplashRoute : AppRoute<SplashViewModel>("SplashScreen", SplashScreen())
}




@Composable
internal fun NavHostController.NavigateAppRoute(startAppRoute: AppRoute<*>) {
    val navController = this
    NavHost(navController, startDestination = startAppRoute.routeName) {

        composable(AppRoute.SplashRoute.routeName){
            AppRoute.SplashRoute.createComposeScreen.Screen(navController, hiltViewModel())
        }

    }

}