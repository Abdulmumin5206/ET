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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

/**
 * Data class representing a bottom navigation item
 */
data class BottomNavItem(
    val route: String,
    val icon: ImageVector,
    val label: String
)

/**
 * Bottom navigation bar component optimized for performance
 * 
 * @param navController Navigation controller to handle navigation between screens
 * @param modifier Optional modifier for customizing the appearance
 */
@Composable
fun BottomNavBar(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    // Using remember to avoid recreating the items list on each recomposition
    val items = remember {
        listOf(
            BottomNavItem(
                route = NavDestinations.Home.route,
                icon = Icons.Default.Home,
                label = "Home"
            ),
            BottomNavItem(
                route = NavDestinations.Statistics.route,
                icon = Icons.Default.Info,
                label = "Statistics"
            ),
            BottomNavItem(
                route = NavDestinations.Downloads.route,
                icon = Icons.Default.List,
                label = "Downloads"
            ),
            BottomNavItem(
                route = NavDestinations.Settings.route,
                icon = Icons.Default.Settings,
                label = "Settings"
            )
        )
    }
    
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
    
    NavigationBar(
        modifier = modifier
    ) {
        items.forEach { item ->
            NavigationBarItem(
                icon = { Icon(item.icon, contentDescription = item.label) },
                label = { Text(item.label) },
                selected = currentRoute == item.route,
                onClick = {
                    if (currentRoute != item.route) {
                        // Simplified navigation without animation options
                        navController.navigate(item.route) {
                            popUpTo(NavDestinations.Home.route)
                            launchSingleTop = true
                        }
                    }
                }
            )
        }
    }
} 