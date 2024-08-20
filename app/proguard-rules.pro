# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

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

# Keep the MainActivity class and all its methods
-keep class com.devapps.justspeak_10.MainActivity {
    *;
}

# Keep all classes in the com.devapps.justspeak_10.ui package and its subpackages
-keep class com.devapps.justspeak_10.ui.** {
    *;
}

# Keep the AuthViewModel class and its methods
-keep class com.devapps.justspeak_10.ui.viewmodels.AuthViewModel {
    *;
}

# Keep the SplashViewModel class and its methods
-keep class com.devapps.justspeak_10.ui.viewmodels.SplashViewModel {
    *;
}

# Keep the UserData class and its methods
-keep class com.devapps.justspeak_10.data.remote.model.UserData {
    *;
}

# Keep the GoogleClientAuth class and its methods
-keep class com.devapps.justspeak_10.data.remote.repository.GoogleClientAuth {
    *;
}

# Keep all classes in the com.devapps.justspeak_10.ui.Components package
-keep class com.devapps.justspeak_10.ui.Components.** {
    *;
}

# Keep all classes in the com.devapps.justspeak_10.ui.Screens.Chichewa package
-keep class com.devapps.justspeak_10.ui.Screens.Chichewa.** {
    *;
}

# Keep all classes in the com.devapps.justspeak_10.ui.Screens.German package
-keep class com.devapps.justspeak_10.ui.Screens.German.** {
    *;
}

# Keep all composable functions
-keepclassmembers class * {
    @androidx.compose.runtime.Composable <methods>;
}

# Keep all Dagger-Hilt injected classes and their methods
-keep class * {
    @dagger.hilt.android.AndroidEntryPoint <methods>;
}

# Keep all androidx.activity classes
-keep class androidx.activity.** {
    *;
}

# Keep BouncyCastle, Conscrypt, and OpenJSSE classes if used
-keep class org.bouncycastle.** { *; }
-keep class org.conscrypt.** { *; }
-keep class org.openjsse.** { *; }

# Keep OkHttp related classes
-keep class okhttp3.internal.platform.** { *; }
