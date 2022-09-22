package com.dp.compose_neostore.ui.features.splash.composes

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.dp.compose_neostore.base.CreateComposeUI

object SplashText : CreateComposeUI<Float>() {


    @Composable
    override fun Create(data: Float) {
        Box(contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()) {
            Text(
                text = "NeoStore",
                 color = Color.White,
                 fontWeight = FontWeight.Bold,
                modifier = Modifier.scale(data),
                style = MaterialTheme.typography.h2,
            )
        }
    }
}