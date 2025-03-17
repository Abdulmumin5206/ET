package com.example.tracker.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tracker.ui.screens.downloads.DownloadsScreen
import com.example.tracker.ui.screens.home.HomeScreen
import com.example.tracker.ui.screens.settings.SettingsScreen
import com.example.tracker.ui.screens.statistics.StatisticsScreen

/**
 * Main navigation component for the app
 * Zero animations, instant page transitions
 */
@Composable
fun AppNavigation() {
    // Create a NavController with no animations
    val navController = rememberNavController()
    
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
            composable(route = NavDestinations.Home.route) {
                HomeScreen()
            }
            composable(route = NavDestinations.Statistics.route) {
                StatisticsScreen()
            }
            composable(route = NavDestinations.Downloads.route) {
                DownloadsScreen()
            }
            composable(route = NavDestinations.Settings.route) {
                SettingsScreen()
            }
        }
    }
} 