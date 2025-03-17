package com.example.tracker.ui.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tracker.ui.screens.downloads.DownloadsScreen
import com.example.tracker.ui.screens.home.HomeScreen
import com.example.tracker.ui.screens.settings.AppearanceScreen
import com.example.tracker.ui.screens.settings.LanguagesScreen
import com.example.tracker.ui.screens.settings.SettingsScreen
import com.example.tracker.ui.screens.statistics.StatisticsScreen

/**
 * Main navigation component for the app
 * Zero animations, instant page transitions
 */
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AppNavigation() {
    // Create a NavController with no animations
    val navController = rememberNavController()
    
    Scaffold(
        bottomBar = {
            // Only show bottom nav on main screens
            val currentRoute = navController.currentBackStackEntry?.destination?.route
            val showBottomBar = currentRoute in listOf(
                NavDestinations.Home.route,
                NavDestinations.Statistics.route,
                NavDestinations.Downloads.route,
                NavDestinations.Settings.route
            )
            
            if (showBottomBar) {
                BottomNavBar(navController = navController)
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = NavDestinations.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            // Main screens with no animations
            composable(
                route = NavDestinations.Home.route,
                enterTransition = { NoAnimationController.noEnterTransition },
                exitTransition = { NoAnimationController.noExitTransition },
                popEnterTransition = { NoAnimationController.noEnterTransition },
                popExitTransition = { NoAnimationController.noExitTransition }
            ) {
                HomeScreen()
            }
            
            composable(
                route = NavDestinations.Statistics.route,
                enterTransition = { NoAnimationController.noEnterTransition },
                exitTransition = { NoAnimationController.noExitTransition },
                popEnterTransition = { NoAnimationController.noEnterTransition },
                popExitTransition = { NoAnimationController.noExitTransition }
            ) {
                StatisticsScreen()
            }
            
            composable(
                route = NavDestinations.Downloads.route,
                enterTransition = { NoAnimationController.noEnterTransition },
                exitTransition = { NoAnimationController.noExitTransition },
                popEnterTransition = { NoAnimationController.noEnterTransition },
                popExitTransition = { NoAnimationController.noExitTransition }
            ) {
                DownloadsScreen()
            }
            
            composable(
                route = NavDestinations.Settings.route,
                enterTransition = { NoAnimationController.noEnterTransition },
                exitTransition = { NoAnimationController.noExitTransition },
                popEnterTransition = { NoAnimationController.noEnterTransition },
                popExitTransition = { NoAnimationController.noExitTransition }
            ) {
                SettingsScreen(navController)
            }
            
            // Settings sub-screens with no animations
            composable(
                route = NavDestinations.Appearance.route,
                enterTransition = { NoAnimationController.noEnterTransition },
                exitTransition = { NoAnimationController.noExitTransition },
                popEnterTransition = { NoAnimationController.noEnterTransition },
                popExitTransition = { NoAnimationController.noExitTransition }
            ) {
                AppearanceScreen(navController)
            }
            
            composable(
                route = NavDestinations.Languages.route,
                enterTransition = { NoAnimationController.noEnterTransition },
                exitTransition = { NoAnimationController.noExitTransition },
                popEnterTransition = { NoAnimationController.noEnterTransition },
                popExitTransition = { NoAnimationController.noExitTransition }
            ) {
                LanguagesScreen(navController)
            }
        }
    }
} 