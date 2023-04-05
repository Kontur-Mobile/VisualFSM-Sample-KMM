plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("com.google.devtools.ksp") version DV.ksp
}

// ===============
// https://github.com/google/ksp/issues/567
// https://github.com/google/ksp/issues/965
dependencies {
    add("kspCommonMainMetadata", "ru.kontur.mobile.visualfsm:visualfsm-compiler:${DV.visualfsm}")
}
// ===============

kotlin {
    android()
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${DV.coroutines}")
                implementation("ru.kontur.mobile.visualfsm:visualfsm-core:${DV.visualfsm}")
                implementation("org.jetbrains.kotlinx:atomicfu:${DV.atomicfu}")

                // ===============
                // https://github.com/google/ksp/issues/567
                // https://github.com/google/ksp/issues/965
                kotlin.srcDir("build/generated/ksp/metadata/commonMain/kotlin")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting
        val androidTest by getting
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

// ===============
// https://github.com/google/ksp/issues/567
// https://github.com/google/ksp/issues/965
tasks.withType<org.jetbrains.kotlin.gradle.dsl.KotlinCompile<*>>().configureEach {
    if (name != "kspCommonMainKotlinMetadata") {
        dependsOn("kspCommonMainKotlinMetadata")
    }
}
// ===============

android {
    compileSdk = 33
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = 23
    }
    namespace = "ru.kontur.mobile.visualfsm.sample_kmm"
}