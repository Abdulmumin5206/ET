package com.example.tracker.ui.screens.statistics

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.tracker.ui.components.NoAnimText

/**
 * Ultra-lightweight statistics screen with zero animations
 */
@Composable
fun StatisticsScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        NoAnimText(
            text = "Expense Statistics",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
    }
} 