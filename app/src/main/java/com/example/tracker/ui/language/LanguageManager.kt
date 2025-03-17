package com.example.tracker.ui.language

import androidx.compose.runtime.mutableStateOf
import java.util.Locale

// Supported languages
enum class AppLanguage(val code: String, val displayName: String) {
    UZBEK("uz", "O'zbekcha"),
    ENGLISH("en", "English"),
    RUSSIAN("ru", "Русский"),
    TURKISH("tr", "Türkçe")
}

// Singleton object to manage language preferences
object LanguageManager {
    // Current language state (default to Uzbek)
    val currentLanguage = mutableStateOf(AppLanguage.UZBEK)
    
    // Set the language
    fun setLanguage(language: AppLanguage) {
        currentLanguage.value = language
    }
    
    // Get the current locale
    fun getCurrentLocale(): Locale {
        return when (currentLanguage.value) {
            AppLanguage.UZBEK -> Locale("uz")
            AppLanguage.ENGLISH -> Locale.ENGLISH
            AppLanguage.RUSSIAN -> Locale("ru")
            AppLanguage.TURKISH -> Locale("tr")
        }
    }
} 