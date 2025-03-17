package com.example.tracker.ui.screens.settings

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Brush
import androidx.compose.material.icons.filled.Language
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tracker.ui.components.NoAnimIconWithText
import com.example.tracker.ui.components.NoAnimText
import com.example.tracker.ui.components.noRippleClickable
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
            NoAnimText(
                text = "Settings",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(16.dp)
            )
            
            // Appearance settings
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .noRippleClickable {
                        navController.navigate(NavDestinations.Appearance.route)
                    }
                    .padding(16.dp)
            ) {
                NoAnimIconWithText(
                    icon = Icons.Default.Brush,
                    text = "Appearance",
                    fontSize = 18.sp
                )
                NoAnimText(
                    text = "Change app theme",
                    fontSize = 14.sp,
                    modifier = Modifier.padding(start = 24.dp, top = 4.dp)
                )
            }
            
            Divider()
            
            // Language settings
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .noRippleClickable {
                        navController.navigate(NavDestinations.Languages.route)
                    }
                    .padding(16.dp)
            ) {
                NoAnimIconWithText(
                    icon = Icons.Default.Language,
                    text = "Language",
                    fontSize = 18.sp
                )
                NoAnimText(
                    text = "Change app language",
                    fontSize = 14.sp,
                    modifier = Modifier.padding(start = 24.dp, top = 4.dp)
                )
            }
            
            Divider()
        }
    }
} 