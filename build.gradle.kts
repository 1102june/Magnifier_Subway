// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false


    id("com.google.gms.google-services") version "4.4.1" apply false
    id("com.google.dagger.hilt.android") version "2.51.1" apply false //Hilt gradle plugin

    id("com.google.devtools.ksp") version "2.0.21-1.0.27" apply false
    // kotlin 버전에 맞는 KSP 버전 사용
}