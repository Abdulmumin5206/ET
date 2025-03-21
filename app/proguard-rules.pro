# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Ultra-aggressive optimizations for minimal app size
-optimizationpasses 10
-dontusemixedcaseclassnames
-dontskipnonpubliclibraryclasses
-dontskipnonpubliclibraryclassmembers
-dontpreverify
-verbose
-allowaccessmodification
-overloadaggressively
-repackageclasses ''
-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*,!code/allocation/variable

# Remove all logging and debug code
-assumenosideeffects class android.util.Log {
    public static *** d(...);
    public static *** v(...);
    public static *** i(...);
    public static *** w(...);
    public static *** e(...);
}

# Remove all annotations
-keepattributes *Annotation*

# Keep only essential classes
-keep public class com.example.tracker.MainActivity
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application

# Aggressively remove unused code
-dontwarn **
-ignorewarnings

# Kotlin specific optimizations
-keepclassmembers class kotlin.Metadata {
    public <methods>;
}

# Keep only essential Compose classes
-keep class androidx.compose.ui.** { *; }
-keep class androidx.compose.material3.** { *; }
-keep class androidx.compose.runtime.** { *; }

# Keep only essential Navigation classes
-keep class androidx.navigation.** { *; }

# Remove all debugging info
-renamesourcefileattribute SourceFile
-keepattributes SourceFile,LineNumberTable

# Aggressively shrink resources
-keep class **.R$* {
    public static final int drawable_*;
    public static final int layout_*;
    public static final int string_*;
}

# Remove all system.out calls
-assumenosideeffects class java.io.PrintStream {
    public void println(...);
    public void print(...);
}

# Keep necessary classes
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application
-keep public class * extends androidx.compose.runtime.Composable

# Remove logging for release builds
-assumenosideeffects class android.util.Log {
    public static *** d(...);
    public static *** v(...);
    public static *** i(...);
}

# Compose specific rules
-keep class androidx.compose.ui.** { *; }
-keep class androidx.compose.material3.** { *; }
-keep class androidx.compose.runtime.** { *; }

# Navigation specific rules
-keep class androidx.navigation.** { *; }

# Keep R classes
-keepclassmembers class **.R$* {
    public static <fields>;
}

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile