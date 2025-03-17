package com.example.tracker.ui.screens.home

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
 * Home screen component - optimized for performance
 * This will be the main screen for expense tracking
 */
@Composable
fun HomeScreen() {
    // Using a simple Box instead of Surface for better performance
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Expense Tracker Home",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
    }
} 