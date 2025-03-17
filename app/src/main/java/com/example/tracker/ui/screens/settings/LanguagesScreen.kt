package com.example.tracker.ui.screens.settings

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tracker.ui.components.NoAnimIcon
import com.example.tracker.ui.components.NoAnimText
import com.example.tracker.ui.components.noRippleClickable
import com.example.tracker.ui.language.AppLanguage
import com.example.tracker.ui.language.LanguageManager

/**
 * Languages settings screen with language options
 */
@Composable
fun LanguagesScreen(navController: NavController) {
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
                Box(
                    modifier = Modifier.noRippleClickable { navController.popBackStack() },
                    contentAlignment = Alignment.Center
                ) {
                    NoAnimIcon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        modifier = Modifier.padding(8.dp)
                    )
                }
                
                NoAnimText(
                    text = "Language",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // Language options
            NoAnimText(
                text = "Select Language",
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // Uzbek language option
            LanguageOption(
                language = AppLanguage.UZBEK,
                isSelected = LanguageManager.currentLanguage.value == AppLanguage.UZBEK,
                onClick = { LanguageManager.setLanguage(AppLanguage.UZBEK) }
            )
            
            Divider()
            
            // English language option
            LanguageOption(
                language = AppLanguage.ENGLISH,
                isSelected = LanguageManager.currentLanguage.value == AppLanguage.ENGLISH,
                onClick = { LanguageManager.setLanguage(AppLanguage.ENGLISH) }
            )
            
            Divider()
            
            // Russian language option
            LanguageOption(
                language = AppLanguage.RUSSIAN,
                isSelected = LanguageManager.currentLanguage.value == AppLanguage.RUSSIAN,
                onClick = { LanguageManager.setLanguage(AppLanguage.RUSSIAN) }
            )
            
            Divider()
            
            // Turkish language option
            LanguageOption(
                language = AppLanguage.TURKISH,
                isSelected = LanguageManager.currentLanguage.value == AppLanguage.TURKISH,
                onClick = { LanguageManager.setLanguage(AppLanguage.TURKISH) }
            )
            
            Divider()
        }
    }
}

/**
 * Language option component
 */
@Composable
private fun LanguageOption(
    language: AppLanguage,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .noRippleClickable(onClick = onClick)
            .padding(16.dp)
    ) {
        NoAnimText(
            text = language.displayName,
            fontSize = 16.sp,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
        )
        
        Spacer(modifier = Modifier.weight(1f))
        
        if (isSelected) {
            NoAnimIcon(
                imageVector = Icons.Default.Check,
                contentDescription = null,
                modifier = Modifier
            )
        }
    }
} 