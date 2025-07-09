plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.ksp)
}

android {
    namespace = "ru.ari.fintracker.core.di"
    compileSdk = 35

    defaultConfig {
        minSdk = 29

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    implementation(libs.androidx.lifecycle.viewmodel.android)
    implementation(libs.retrofit)

    implementation(projects.core.data)
    implementation(projects.core.network)
    implementation(projects.core.domain)
    implementation(projects.core.common)

    implementation(libs.dagger)
    ksp(libs.dagger.compiler)
}