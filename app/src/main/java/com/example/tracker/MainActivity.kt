package com.example.tracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.example.tracker.ui.navigation.AppNavigation
import com.example.tracker.ui.theme.TrackerTheme

/**
 * Main activity for the Expense Tracker app
 * Optimized for performance and minimal memory usage
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Enable edge-to-edge display
        enableEdgeToEdge()
        setContent {
            // Use the app theme with minimal overhead
            TrackerTheme(dynamicColor = false) {
                // Direct navigation without extra Surface container
                AppNavigation()
            }
        }
    }
}