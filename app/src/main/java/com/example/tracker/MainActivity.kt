package com.example.tracker

import android.os.Bundle
import android.view.ViewGroup
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalView
import com.example.tracker.ui.navigation.AppNavigation
import com.example.tracker.ui.theme.ThemeManager
import com.example.tracker.ui.theme.TrackerTheme

/**
 * Main activity for the Expense Tracker app
 * Completely disables all animations for maximum performance
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Disable all window animations
        window.setWindowAnimations(0)
        
        // Enable edge-to-edge display
        enableEdgeToEdge()
        
        setContent {
            // Get current theme from ThemeManager
            val currentTheme = ThemeManager.currentTheme.value
            
            // Use minimal theme with no animations
            TrackerTheme(
                appTheme = currentTheme,
                dynamicColor = false
            ) {
                // Force disable any remaining animations
                val view = LocalView.current
                if (view.parent is ViewGroup) {
                    (view.parent as ViewGroup).layoutAnimation = null
                }
                
                // Direct navigation with no containers
                AppNavigation()
            }
        }
    }
    
    override fun onResume() {
        super.onResume()
        // Disable activity transition animations
        overridePendingTransition(0, 0)
    }
    
    override fun onPause() {
        super.onPause()
        // Disable activity transition animations
        overridePendingTransition(0, 0)
    }
}