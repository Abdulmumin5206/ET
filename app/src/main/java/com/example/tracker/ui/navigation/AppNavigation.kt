package com.example.tracker.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tracker.ui.screens.downloads.DownloadsScreen
import com.example.tracker.ui.screens.home.HomeScreen
import com.example.tracker.ui.screens.settings.SettingsScreen
import com.example.tracker.ui.screens.statistics.StatisticsScreen

/**
 * Main navigation component for the app
 * Sets up the navigation host and bottom navigation bar
 * Configured for instant page transitions without animations
 */
@Composable
fun AppNavigation() {
    val navController = rememberNavController().apply {
        // Disable animations for instant page transitions
        disableAnimations()
    }
    
    Scaffold(
        bottomBar = {
            BottomNavBar(navController = navController)
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = NavDestinations.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(
                route = NavDestinations.Home.route,
                enterTransition = { null },
                exitTransition = { null },
                popEnterTransition = { null },
                popExitTransition = { null }
            ) {
                HomeScreen()
            }
            composable(
                route = NavDestinations.Statistics.route,
                enterTransition = { null },
                exitTransition = { null },
                popEnterTransition = { null },
                popExitTransition = { null }
            ) {
                StatisticsScreen()
            }
            composable(
                route = NavDestinations.Downloads.route,
                enterTransition = { null },
                exitTransition = { null },
                popEnterTransition = { null },
                popExitTransition = { null }
            ) {
                DownloadsScreen()
            }
            composable(
                route = NavDestinations.Settings.route,
                enterTransition = { null },
                exitTransition = { null },
                popEnterTransition = { null },
                popExitTransition = { null }
            ) {
                SettingsScreen()
            }
        }
    }
}

/**
 * Extension function to disable animations in NavController
 */
private fun NavHostController.disableAnimations() {
    addOnDestinationChangedListener { _, _, _ ->
        // This ensures no animations are played when destinations change
        currentBackStack.value.forEach { entry ->
            entry.arguments?.putBoolean("android:anim", false)
        }
    }
} 