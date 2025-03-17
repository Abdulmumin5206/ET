package com.example.tracker.ui.screens.downloads

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

/**
 * Ultra-lightweight downloads screen with zero animations
 */
@Composable
fun DownloadsScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Downloads",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
    }
} 