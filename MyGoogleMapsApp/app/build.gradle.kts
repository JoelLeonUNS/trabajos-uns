plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.mygooglemapsapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.mygooglemapsapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        viewBinding = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation ("com.google.android.gms:play-services-maps:17.0.1")
    implementation ("com.google.android.libraries.places:places:2.4.0")
    implementation ("com.google.maps:google-maps-services:0.18.0")
    implementation ("org.slf4j:slf4j-simple:1.7.25")
    implementation ("com.google.maps.android:android-maps-utils:3.4.0")
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}