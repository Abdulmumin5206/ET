package com.example.tracker.ui.navigation

/**
 * Contains all navigation destinations for the app
 */
sealed class NavDestinations(val route: String) {
    object Home : NavDestinations("home")
    object Statistics : NavDestinations("statistics")
    object Downloads : NavDestinations("downloads")
    object Settings : NavDestinations("settings")
    
    companion object {
        val bottomNavItems = listOf(Home, Statistics, Downloads, Settings)
    }
} 