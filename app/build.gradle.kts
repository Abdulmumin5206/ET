plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.example.tracker"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.tracker"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        
        // Enable multidex for smaller app size
        multiDexEnabled = true
        
        // Optimize vector drawables
        vectorDrawables.useSupportLibrary = true
    }

    buildTypes {
        release {
            // Enable minification to reduce code size
            isMinifyEnabled = true
            // Enable resource shrinking to remove unused resources
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        
        debug {
            // Enable minification in debug builds too for testing
            isMinifyEnabled = true
            // Enable resource shrinking in debug builds too
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    
    // Optimize APK packaging
    packaging {
        resources {
            // Exclude unnecessary files from the APK
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
            excludes += "META-INF/LICENSE.txt"
            excludes += "META-INF/NOTICE.txt"
            excludes += "META-INF/*.kotlin_module"
        }
    }
    
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    
    kotlinOptions {
        jvmTarget = "11"
        // Enable compiler optimizations
        freeCompilerArgs += listOf("-Xopt-in=kotlin.RequiresOptIn")
    }
    
    buildFeatures {
        compose = true
        // Disable unnecessary build features
        buildConfig = false
        aidl = false
        renderScript = false
        resValues = false
        shaders = false
    }
    
    // Optimize Compose compiler
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.8"
    }
}

dependencies {
    // Core dependencies - keep only what's necessary
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    
    // Compose dependencies - use BOM for consistent versions
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.material3)
    
    // Navigation - use a specific implementation to reduce size
    implementation("androidx.navigation:navigation-compose:2.7.7")
    
    // Icons - only include what we need
    implementation("androidx.compose.material:material-icons-core:1.6.3")
    
    // Debug-only dependencies
    debugImplementation(libs.androidx.ui.tooling)
    
    // Test dependencies - only needed for testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}