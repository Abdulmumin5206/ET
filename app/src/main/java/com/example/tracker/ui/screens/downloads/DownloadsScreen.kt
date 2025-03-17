package com.example.tracker.ui.screens.downloads

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Downloads screen component - optimized for performance
 * This will allow users to download expense reports
 */
@Composable
fun DownloadsScreen() {
    // Using a simple Box instead of Surface for better performance
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Downloads",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
    }
} 