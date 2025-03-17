package com.example.tracker.ui.theme

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.map

// Singleton object to manage theme preferences
object ThemeManager {
    // Current theme state
    val currentTheme = mutableStateOf(AppTheme.LIGHT)
    
    // Set the theme
    fun setTheme(theme: AppTheme) {
        currentTheme.value = theme
    }
} 