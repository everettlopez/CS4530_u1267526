package com.example.myapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp

@Composable
fun MarbleGameScreen(viewModel: MarbleViewModel) {
    val posX by viewModel.posX.collectAsState()
    val posY by viewModel.posY.collectAsState()

    val density = LocalDensity.current
    val marbleSizeDp = 40.dp
    val marbleSizePx = with(density) { marbleSizeDp.toPx() }

    BoxWithConstraints(
        modifier = Modifier.fillMaxSize()
    ) {
        val maxWidthPx = with(density) { maxWidth.toPx() }
        val maxHeightPx = with(density) { maxHeight.toPx() }

        LaunchedEffect(maxWidthPx, maxHeightPx) {
            viewModel.setScreenBounds(maxWidthPx, maxHeightPx, marbleSizePx)
        }

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                Box(
                    modifier = Modifier
                        .offset(
                            x = with(density) { posX.toDp() },
                            y = with(density) { posY.toDp() }
                        )
                        .size(marbleSizeDp)
                        .background(Color.Blue, CircleShape)
                )
            }
        }
    }
}
