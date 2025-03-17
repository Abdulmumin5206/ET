package com.example.tracker.ui.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDestination
import androidx.navigation.NavOptions
import androidx.navigation.Navigator

/**
 * Custom animation controller that completely disables all animations
 */
object NoAnimationController {
    // Zero duration for any required transitions
    private const val ZERO_DURATION = 0
    
    // Null transitions for enter/exit
    val noEnterTransition: EnterTransition? = null
    val noExitTransition: ExitTransition? = null
    
    // Zero duration tween for any required animations
    val zeroTween = tween<Float>(durationMillis = ZERO_DURATION)
    
    // Custom transition spec that returns null for all transitions
    val noTransitionSpec: AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition? = { null }
} 