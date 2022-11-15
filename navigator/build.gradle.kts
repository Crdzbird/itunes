plugins {
    id(BuildPlugins.ANDROID_APPLICATION_LIBRARY_PLUGIN)
    id(BuildPlugins.KOTLIN_ANDROID_PLUGIN)
    id(BuildPlugins.KOTLIN_KAPT)
}

android {
    compileSdk = ProjectProperties.COMPILE_SDK

    defaultConfig {
        minSdk = ProjectProperties.MIN_SDK
        targetSdk = ProjectProperties.TARGET_SDK
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Lib.Compose.COMPOSE_VERSION
    }
}

dependencies {

    implementation(Lib.Android.KOTLIN_CORE_PLUGIN)
    implementation(Lib.Android.ANDROIDX_APPCOMPAT_PLUGIN)
    implementation(Lib.Android.MATERIAL_PLUGIN)
    implementation(Lib.Android.ANDROIDX_LIFECYCLE_RUNTIME_PLUGIN)
    implementation(Lib.Android.ANDROIDX_ACTIVITY_COMPOSE_PLUGIN)
    implementation(Lib.Compose.COMPOSE_UI_PLUGIN)
    implementation(Lib.Compose.COMPOSE_MATERIAL_PLUGIN)
    implementation(DaggerHilt.DAGGER_HILT_NAVIGATION_COMPOSE)
    implementation(DaggerHilt.DAGGER_HILT_NAVIGATION)
    implementation(DaggerHilt.DAGGER_HILT_COMMON)
    implementation(DaggerHilt.DAGGER_HILT_WORK)
    implementation(Lib.Navigation.NAVIGATION_COMPOSE_PLUGIN)
    kapt(DaggerHilt.DAGGER_HILT_COMPILER)
    testImplementation(Lib.Android.JUNIT_PLUGIN)
    androidTestImplementation(Lib.Android.JUNIT_EXTENSION_PLUGIN)
    androidTestImplementation(Lib.Android.ESPRESSO_CORE_PLUGIN)
}