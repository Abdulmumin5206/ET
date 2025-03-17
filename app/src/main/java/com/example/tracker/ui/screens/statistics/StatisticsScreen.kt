package com.example.tracker.ui.screens.statistics

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
 * Statistics screen component - optimized for performance
 * This will show expense statistics and visualizations
 */
@Composable
fun StatisticsScreen() {
    // Using a simple Box instead of Surface for better performance
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Expense Statistics",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
    }
} 