package com.dp.compose_neostore.base

import android.os.Bundle
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController

abstract class CreateComposeScreen<VM : ViewModel> {

    private var args: Bundle? = null

    fun putArgs(args: Bundle?) {
        this.args = args
    }

    fun getArgs(): Bundle? = args

    @Composable
    fun Screen(navController: NavController, vm: VM) {
        Surface(modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background) {
            Create(navController, vm)
        }
    }


    @Composable
    abstract fun Create(navController: NavController, vm: VM)
}