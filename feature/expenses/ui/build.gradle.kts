plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlinx.serialization.plugin)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "ru.ari.feature.expenses.ui"
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
    implementation(libs.androidx.material3)
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.tooling)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(platform(libs.androidx.compose.bom))

    implementation(projects.core.ui)
    implementation(projects.feature.expenses.domain)
    implementation(libs.androidx.lifecycle.viewmodel.compose)

    androidTestImplementation(platform(libs.androidx.compose.bom))
}