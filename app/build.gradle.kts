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
        
        // Enable multidex for smaller app size
        multiDexEnabled = true
        
        // Optimize vector drawables
        vectorDrawables.useSupportLibrary = true
    }

    buildTypes {
        release {
            // Maximum optimization for release builds
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        
        debug {
            // Enable optimization for debug builds too
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    
    // Aggressively optimize APK packaging
    packaging {
        resources {
            // Exclude all unnecessary files
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
            excludes += "META-INF/LICENSE*"
            excludes += "META-INF/NOTICE*"
            excludes += "META-INF/*.kotlin_module"
            excludes += "META-INF/DEPENDENCIES"
            excludes += "**.properties"
            excludes += "kotlin/**"
            excludes += "**.bin"
            excludes += "**.json"
            excludes += "**.proto"
            excludes += "**/*.proto"
            excludes += "org/intellij/**"
            excludes += "org/jetbrains/**"
            excludes += "**/*.java"
            excludes += "**/*.class"
        }
        
        // Don't include multiple APKs
        jniLibs {
            useLegacyPackaging = true
        }
    }
    
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    
    kotlinOptions {
        jvmTarget = "11"
        // Enable all compiler optimizations
        freeCompilerArgs += listOf(
            "-Xopt-in=kotlin.RequiresOptIn",
            "-Xno-param-assertions",
            "-Xno-call-assertions",
            "-Xno-receiver-assertions"
        )
    }
    
    buildFeatures {
        // Only enable essential features
        compose = true
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
    // Absolute minimum dependencies
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.activity.compose)
    
    // Minimal Compose dependencies
    implementation("androidx.compose.ui:ui:1.6.3")
    implementation("androidx.compose.material3:material3:1.2.0")
    
    // Navigation dependencies
    implementation("androidx.navigation:navigation-compose:2.7.7")
    
    // Minimal Icons - only core icons
    implementation("androidx.compose.material:material-icons-core:1.6.3")
    implementation("androidx.compose.material:material-icons-extended:1.6.3")
    
    // DataStore for preferences
    implementation("androidx.datastore:datastore-preferences:1.0.0")
}