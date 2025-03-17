package com.example.tracker.ui.screens.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tracker.ui.theme.AppTheme
import com.example.tracker.ui.theme.DarkBackground
import com.example.tracker.ui.theme.Green40
import com.example.tracker.ui.theme.Green80
import com.example.tracker.ui.theme.LightBackground
import com.example.tracker.ui.theme.Pink80
import com.example.tracker.ui.theme.PinkBackground
import com.example.tracker.ui.theme.ThemeManager

/**
 * Appearance settings screen with theme options
 */
@Composable
fun AppearanceScreen(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            // Header with back button
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(8.dp)
            ) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        Icons.Default.ArrowBack,
                        contentDescription = "Back"
                    )
                }
                
                Text(
                    text = "Appearance",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // Theme options
            Text(
                text = "Select Theme",
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // Light theme option
            ThemeOption(
                name = "Light Theme",
                color = LightBackground,
                accentColor = Green80,
                isSelected = ThemeManager.currentTheme.value == AppTheme.LIGHT,
                onClick = { ThemeManager.setTheme(AppTheme.LIGHT) }
            )
            
            // Dark theme option
            ThemeOption(
                name = "Dark Theme",
                color = DarkBackground,
                accentColor = Green40,
                isSelected = ThemeManager.currentTheme.value == AppTheme.DARK,
                onClick = { ThemeManager.setTheme(AppTheme.DARK) }
            )
            
            // Pink theme option
            ThemeOption(
                name = "Pink Theme",
                color = PinkBackground,
                accentColor = Pink80,
                isSelected = ThemeManager.currentTheme.value == AppTheme.PINK,
                onClick = { ThemeManager.setTheme(AppTheme.PINK) }
            )
        }
    }
}

/**
 * Theme option component
 */
@Composable
private fun ThemeOption(
    name: String,
    color: Color,
    accentColor: Color,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(16.dp)
    ) {
        // Theme color preview
        Box(
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
                .background(color)
                .border(
                    width = if (isSelected) 2.dp else 0.dp,
                    color = if (isSelected) MaterialTheme.colorScheme.primary else Color.Transparent,
                    shape = CircleShape
                )
        ) {
            // Accent color dot
            Box(
                modifier = Modifier
                    .size(16.dp)
                    .clip(CircleShape)
                    .background(accentColor)
                    .align(Alignment.Center)
            )
        }
        
        Spacer(modifier = Modifier.width(16.dp))
        
        Text(
            text = name,
            fontSize = 16.sp,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
        )
    }
} 