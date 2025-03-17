package com.example.tracker.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

/**
 * Ultra-lightweight bottom navigation bar
 * No animations, instant page transitions
 */
@Composable
fun BottomNavBar(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    // Pre-compute navigation items to avoid recreations
    val items = remember {
        listOf(
            NavItem(NavDestinations.Home.route, Icons.Default.Home, "Home"),
            NavItem(NavDestinations.Statistics.route, Icons.Default.Info, "Statistics"),
            NavItem(NavDestinations.Downloads.route, Icons.Default.List, "Downloads"),
            NavItem(NavDestinations.Settings.route, Icons.Default.Settings, "Settings")
        )
    }
    
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
    
    NavigationBar(modifier = modifier) {
        items.forEach { item ->
            NavigationBarItem(
                icon = { Icon(item.icon, contentDescription = null) },
                label = { Text(item.label) },
                selected = currentRoute == item.route,
                onClick = {
                    if (currentRoute != item.route) {
                        // Direct navigation with no animations
                        navController.navigate(item.route) {
                            // Clear back stack for instant navigation
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = false
                            }
                            // Avoid multiple copies of the same destination
                            launchSingleTop = true
                            // Don't restore state to avoid animations
                            restoreState = false
                        }
                    }
                }
            )
        }
    }
}

// Simplified data class to reduce memory usage
private data class NavItem(
    val route: String,
    val icon: androidx.compose.ui.graphics.vector.ImageVector,
    val label: String
) 