package com.dp.compose_neostore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.dp.compose_neostore.ui.theme.NeostoreComposeDemoTheme
import com.dp.compose_neostore.utils.AppRoute
import com.dp.compose_neostore.utils.NavigateAppRoute
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