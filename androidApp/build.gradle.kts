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
        kotlinCompilerExtensionVersion = DV.composeCompiler
    }
}

dependencies {
    implementation(project(":shared"))
    implementation("ru.kontur.mobile.visualfsm:visualfsm-core:${DV.visualfsm}")

    implementation("androidx.core:core-ktx:${DV.coreKTX}")
    implementation("androidx.compose.ui:ui:${DV.compose}")
    implementation("androidx.compose.material:material:${DV.compose}")
    implementation("androidx.compose.ui:ui-tooling-preview:${DV.compose}")
    implementation("androidx.activity:activity-compose:${DV.activityCompose}")
}