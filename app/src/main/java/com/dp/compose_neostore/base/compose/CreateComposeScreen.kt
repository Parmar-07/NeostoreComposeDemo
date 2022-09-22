package com.dp.compose_neostore.base.compose

import android.os.Bundle
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

abstract class CreateComposeScreen<VM : ViewModel, Data : java.io.Serializable> {

    protected lateinit var viewModel: VM
    protected lateinit var navController: NavController
    protected lateinit var data: Data
    protected lateinit var coroutineScope: CoroutineScope
    protected lateinit var scaffoldState: ScaffoldState
    internal var initScreen = false
    internal lateinit var snackbarState: SnackbarHostState

    @Composable
    open fun getSurfaceBackGroundColor(): Color {
        return MaterialTheme.colors.background
    }

    @Suppress("UNCHECKED_CAST")
    @Composable
    fun Screen(navController: NavController, vm: VM, uiData: Data, args: Bundle?) {
        this.navController = navController
        this.scaffoldState = rememberScaffoldState()
        this.coroutineScope = rememberCoroutineScope()
        snackbarState = scaffoldState.snackbarHostState
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
            initScreen = init.value
            LaunchedEffect(key1 = true) {
                if (!init.value) {
                    onInitData(this, args)
                    onObserveEvents(coroutineScope)
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

    open suspend fun onObserveEvents(coroutineScope: CoroutineScope) {

    }

    suspend fun showSnackBarMessage(message: String) {
        scaffoldState.snackbarHostState.showSnackbar(message)
    }

    suspend fun showSnackBarMessageWithAction(
        message: String,
        actionLabel: String,
        onPerformAction: () -> Unit,
    ) {
        coroutineScope.launch {
            val callback = scaffoldState.snackbarHostState.showSnackbar(
                message,
                actionLabel
            )
            if (callback == SnackbarResult.ActionPerformed) {
                onPerformAction.invoke()
            }
        }
    }


}