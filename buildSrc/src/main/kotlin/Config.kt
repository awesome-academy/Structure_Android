
object Versions {

    const val gradlePlugin = "8.2.1"
    const val kotlin = "1.9.22"

    const val coreKtx = "1.9.0"
    const val appCompat = "1.6.1"
    const val material = "1.8.0"
    const val constraintLayout = "2.1.4"
    const val coreSplashScreen = "1.0.0"

    const val lifecycle = "2.5"
    const val navigation = "2.5.3"
    
    const val coroutines = "1.4.2"

    const val retrofit = "2.9.0"
    const val okHttp = "4.7.2"

    const val glide = "4.11.0"

    const val koin = "3.4.0"

    const val room = "2.5.2"

    const val jUnit = "4.13.2"
    const val mockk = "1.13.2"

    const val ktlint = "0.48.1"
    const val detekt = "1.23.3"
}

object AppConfigs {
    const val application_id = "com.sun.structure_android"
    const val compile_sdk_version = 34
    const val min_sdk_version = 23
    const val target_sdk_version = 34
    const val version_code = 1
    const val version_name = "1.0"
    const val version_code_release = 1
    const val version_name_release = "1.0"
}

object ClassPath {
    const val gradle_build_tools = "com.android.tools.build:gradle:${Versions.gradlePlugin}"
    const val kotlin_gradle_plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
}

object Plugins {
    const val android_application = "com.android.application"
    const val kotlin_android = "android"
    const val kotlin_parcelize = "kotlin-parcelize"
    const val detekt = "io.gitlab.arturbosch.detekt"
}

object Deps {
    const val core_ktx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val constraint_layout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"

    // navigation
    const val navigation_fragment = "androidx.navigation:navigation-fragment:${Versions.navigation}"
    const val navigation_ui = "androidx.navigation:navigation-ui:${Versions.navigation}"
    const val navigation_fragment_ktx = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigation_ui_ktx = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"

    // Lifecycle
    const val lifecycle_livedata_ktx = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    const val lifecycle_viewmodel_ktx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val lifecycle_runtime = "androidx.lifecycle:lifecycle-runtime:${Versions.lifecycle}"

    // Coroutines
    const val coroutines_core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val coroutines_android =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    const val coroutines_test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"

    //Retrofit
    const val retrofit_runtime = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
    const val retrofit_gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val okhttp_logging_interceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"

    // Glide
    const val glide_runtime = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glide_compiler = "com.github.bumptech.glide:compiler:${Versions.glide}"

    // Koin
    const val koin = "io.insert-koin:koin-android:${Versions.koin}"

    // Room
    const val room_runtime = "androidx.room:room-runtime:${Versions.room}"
    const val room_ksp = "androidx.room:room-compiler:${Versions.room}"
    const val room_ktx = "androidx.room:room-ktx:${Versions.room}"

    // Testing
    const val junit = "junit:junit:${Versions.jUnit}"
    const val mockk = "io.mockk:mockk:${Versions.mockk}"

    // Ktlint
    const val ktlint = "com.pinterest:ktlint:${Versions.ktlint}"
}
