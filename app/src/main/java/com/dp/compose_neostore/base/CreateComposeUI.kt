package com.dp.compose_neostore.base

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.dp.compose_neostore.ui.showToast

abstract class CreateComposeUI<Data> {

    @Composable
    abstract fun Create(data: Data)


}