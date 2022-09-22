package com.dp.compose_neostore.base

import android.os.Bundle
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import kotlinx.coroutines.CoroutineScope

abstract class CreateComposeScreen<VM : ViewModel, Data : java.io.Serializable> {

    protected lateinit var viewModel: VM
    protected lateinit var navController: NavController
    protected lateinit var data: Data

    @Composable
    open fun getSurfaceBackGroundColor(): Color {
        return MaterialTheme.colors.background
    }

    @Suppress("UNCHECKED_CAST")
    @Composable
    fun Screen(navController: NavController, vm: VM, uiData: Data, args: Bundle?) {
        this.navController = navController
        this.viewModel = remember { vm }
        val savedData = rememberSaveable {
            Bundle().apply {
                putSerializable("uiData", uiData)
            }
        }
        this.data = (savedData.getSerializable("uiData") as Data?) ?: uiData
        Surface(modifier = Modifier.fillMaxSize(),
            color = getSurfaceBackGroundColor()) {
            val init = rememberSaveable { mutableStateOf(false) }
            LaunchedEffect(key1 = true) {
                if (!init.value) {
                    onInitData(this, args)
                    init.value = true
                }
            }

            DrawCompose()
        }
    }


    @Composable
    abstract fun DrawCompose()

    open suspend fun onInitData(coroutineScope: CoroutineScope, args: Bundle?) {

    }


}