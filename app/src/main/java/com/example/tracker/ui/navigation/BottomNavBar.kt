package com.example.tracker.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalanceWallet
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShowChart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
 * List of bottom navigation items with their respective icons and labels
 */
val bottomNavItems = listOf(
    BottomNavItem(
        route = NavDestinations.Home.route,
        icon = Icons.Default.AccountBalanceWallet,
        label = "Home"
    ),
    BottomNavItem(
        route = NavDestinations.Statistics.route,
        icon = Icons.Default.ShowChart,
        label = "Statistics"
    ),
    BottomNavItem(
        route = NavDestinations.Downloads.route,
        icon = Icons.Default.Download,
        label = "Downloads"
    ),
    BottomNavItem(
        route = NavDestinations.Settings.route,
        icon = Icons.Default.Settings,
        label = "Settings"
    )
)

/**
 * Bottom navigation bar component
 * 
 * @param navController Navigation controller to handle navigation between screens
 * @param modifier Optional modifier for customizing the appearance
 */
@Composable
fun BottomNavBar(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
    
    NavigationBar(
        modifier = modifier
    ) {
        bottomNavItems.forEach { item ->
            NavigationBarItem(
                icon = { Icon(item.icon, contentDescription = item.label) },
                label = { Text(item.label) },
                selected = currentRoute == item.route,
                onClick = {
                    if (currentRoute != item.route) {
                        navController.navigate(item.route) {
                            // Pop up to the start destination of the graph to
                            // avoid building up a large stack of destinations
                            popUpTo(NavDestinations.Home.route) {
                                saveState = true
                            }
                            // Avoid multiple copies of the same destination when
                            // reselecting the same item
                            launchSingleTop = true
                            // Restore state when reselecting a previously selected item
                            restoreState = true
                        }
                    }
                }
            )
        }
    }
} 