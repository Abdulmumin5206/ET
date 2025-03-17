package com.example.tracker.ui.screens.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import com.example.tracker.ui.components.NoAnimText

/**
 * Ultra-lightweight home screen with zero animations
 */
@Composable
fun HomeScreen() {
    // Using a simple Box for maximum performance
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        // Text with no animations from common components
        NoAnimText(
            text = "Expense Tracker Home",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

/**
 * Text component with no animations
 */
@Composable
fun NoAnimText(
    text: String,
    fontSize: androidx.compose.ui.unit.TextUnit,
    fontWeight: FontWeight = FontWeight.Normal,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        fontSize = fontSize,
        fontWeight = fontWeight,
        modifier = modifier,
        softWrap = true,
        overflow = TextOverflow.Visible, // No ellipsis animation
        maxLines = Int.MAX_VALUE // No line truncation animation
    )
} 