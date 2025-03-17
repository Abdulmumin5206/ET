package com.example.tracker

import android.os.Bundle
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsAnimationCompat
import androidx.core.view.WindowInsetsCompat
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
        
        // Disable all transition animations
        window.sharedElementEnterTransition = null
        window.sharedElementExitTransition = null
        window.sharedElementReenterTransition = null
        window.sharedElementReturnTransition = null
        
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
                
                // Disable layout animations
                if (view.parent is ViewGroup) {
                    (view.parent as ViewGroup).layoutAnimation = null
                    (view.parent as ViewGroup).layoutTransition = null
                }
                
                // Disable inset animations
                DisposableEffect(view) {
                    val listener = object : WindowInsetsAnimationCompat.Callback(DISPATCH_MODE_CONTINUE_ON_SUBTREE) {
                        override fun onPrepare(animation: WindowInsetsAnimationCompat) {
                            // Cancel the animation
                            animation.fraction = 1.0f
                        }
                        
                        override fun onProgress(
                            insets: WindowInsetsCompat,
                            runningAnimations: MutableList<WindowInsetsAnimationCompat>
                        ): WindowInsetsCompat {
                            // Skip animation by returning the final insets immediately
                            return insets
                        }
                    }
                    
                    ViewCompat.setWindowInsetsAnimationCallback(view, listener)
                    
                    onDispose {
                        ViewCompat.setWindowInsetsAnimationCallback(view, null)
                    }
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