package com.example.tracker

import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.platform.LocalView
import com.example.tracker.ui.navigation.AppNavigation
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
            // Use minimal theme with no animations
            TrackerTheme(dynamicColor = false) {
                // Force disable any remaining animations
                LocalView.current.apply {
                    layoutAnimation = null
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