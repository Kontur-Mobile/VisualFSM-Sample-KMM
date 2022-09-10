plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdk = 32
    defaultConfig {
        applicationId = "ru.kontur.mobile.visualfsm.sample_kmm.android"
        minSdk = 23
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.0"
    }
}

dependencies {
    implementation(project(":shared"))
    implementation("ru.kontur.mobile.visualfsm:visualfsm-core:1.1.1")

    implementation("androidx.core:core-ktx:1.8.0")
    implementation("androidx.compose.ui:ui:1.2.1")
    implementation("androidx.compose.material:material:1.2.1")
    implementation("androidx.compose.ui:ui-tooling-preview:1.2.1")
    implementation("androidx.activity:activity-compose:1.5.1")
}