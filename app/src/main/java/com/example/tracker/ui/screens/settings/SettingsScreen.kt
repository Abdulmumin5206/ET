package com.example.tracker.ui.screens.settings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Brush
import androidx.compose.material.icons.filled.Language
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tracker.ui.navigation.NavDestinations

/**
 * Ultra-lightweight settings screen with zero animations
 */
@Composable
fun SettingsScreen(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Settings",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(16.dp)
            )
            
            // Appearance settings
            ListItem(
                headlineContent = { Text("Appearance") },
                supportingContent = { Text("Change app theme") },
                leadingContent = { 
                    Icon(
                        Icons.Default.Brush,
                        contentDescription = null
                    )
                },
                modifier = Modifier.clickable {
                    navController.navigate(NavDestinations.Appearance.route)
                }
            )
            
            Divider()
            
            // Language settings
            ListItem(
                headlineContent = { Text("Language") },
                supportingContent = { Text("Change app language") },
                leadingContent = { 
                    Icon(
                        Icons.Default.Language,
                        contentDescription = null
                    )
                },
                modifier = Modifier.clickable {
                    navController.navigate(NavDestinations.Languages.route)
                }
            )
            
            Divider()
        }
    }
} 