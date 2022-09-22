package com.dp.compose_neostore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.dp.compose_neostore.base.compose.AppRoute
import com.dp.compose_neostore.base.compose.NavigateAppRoute
import com.dp.compose_neostore.ui.theme.NeostoreComposeDemoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NeostoreComposeDemoTheme {
                // A surface container using the 'background' color from the theme
                rememberNavController()
                    .NavigateAppRoute(startAppRoute = AppRoute.SplashRoute)

            }
        }
    }
}