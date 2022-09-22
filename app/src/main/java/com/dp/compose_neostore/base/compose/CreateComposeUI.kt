package com.dp.compose_neostore.base.compose

import androidx.compose.runtime.Composable

abstract class CreateComposeUI<Data> {

    @Composable
    abstract fun Create(data: Data)


}