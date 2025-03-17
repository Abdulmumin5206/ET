package com.example.tracker.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

// Simplified color schemes for better performance
private val DarkColorScheme = darkColorScheme(
    primary = Green40,
    secondary = GreenVariant40,
    tertiary = Blue40,
    background = DarkBackground,
    surface = DarkBackground
)

private val LightColorScheme = lightColorScheme(
    primary = Green80,
    secondary = GreenVariant80,
    tertiary = Blue80,
    background = LightBackground,
    surface = LightBackground
)

private val PinkColorScheme = lightColorScheme(
    primary = Pink80,
    secondary = PinkVariant80,
    tertiary = PinkAccent80,
    background = PinkBackground,
    surface = PinkBackground
)

// Theme enum for storing user preference
enum class AppTheme {
    LIGHT, DARK, PINK
}

// Composition local to access the current theme
val LocalAppTheme = staticCompositionLocalOf { AppTheme.LIGHT }

/**
 * App theme optimized for performance
 */
@Composable
fun TrackerTheme(
    appTheme: AppTheme = LocalAppTheme.current,
    // Dynamic color disabled by default for better performance
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when (appTheme) {
        AppTheme.DARK -> DarkColorScheme
        AppTheme.PINK -> PinkColorScheme
        else -> LightColorScheme
    }
    
    // Set status bar color
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = appTheme != AppTheme.DARK
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}