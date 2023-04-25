import org.gradle.api.JavaVersion

object Config {
    const val applicationId = "com.volokhinaleksey.take_are_of_your_health"
    const val minSdk = 27
    const val targetSdk = 33
    const val compileSdk = 33
    val javaVersion = JavaVersion.VERSION_1_8
}

object Versions {
    // Coroutines
    const val coroutinesCore = "1.6.4"
    const val coroutinesAndroid = "1.6.4"
    const val coroutinesTest = "1.6.4"

    // Compose
    const val composeBom = "2023.03.00"
    const val activityCompose = "1.7.0"
    const val composeViewModel = "2.6.1"
    const val composeMaterial3 = "1.1.0-alpha06"

    // Koin
    const val koinCore = "3.3.3"
    const val androidKoin = "3.3.3"
    const val composeKoin = "3.4.3"

    // Android Ktx
    const val ktx = "1.7.0"

    // Lifecycle
    const val lifecycleLivedata = "2.6.1"
    const val lifecycleViewModel = "2.6.1"

    // Firebase
    const val firebaseDatabase = "24.5.0"

    // Tests
    const val junit = "4.13.2"
    const val extJunit = "1.1.5"
    const val espressoCore = "3.5.1"
}

object Releases {
    const val versionCode = 1
    const val versionName = "1.0"
}

object Coroutines {
    const val coroutinesCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesCore}"
    const val coroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesAndroid}"
    const val coroutinesTest =
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutinesTest}"
}

object Koin {
    const val koinCore = "io.insert-koin:koin-core:${Versions.koinCore}"
    const val koinAndroid = "io.insert-koin:koin-android:${Versions.androidKoin}"
    const val composeKoin = "io.insert-koin:koin-androidx-compose:${Versions.composeKoin}"
}

object Firebase {
    const val firebaseDatabase = "com.google.firebase:firebase-firestore-ktx:${Versions.firebaseDatabase}"
}

object Compose {
    const val composeBom = "androidx.compose:compose-bom:${Versions.composeBom}"
    const val composeMaterial3 = "androidx.compose.material3:material3:${Versions.composeMaterial3}"
    const val composeUi = "androidx.compose.ui:ui"
    const val composeUiTooling = "androidx.compose.ui:ui-tooling-preview"
    const val composeActivity = "androidx.activity:activity-compose:${Versions.activityCompose}"
    const val composeViewModel =
        "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.composeViewModel}"
    const val composeLiveData = "androidx.compose.runtime:runtime-livedata"
}

object Lifecycle {
    const val livedata = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycleLivedata}"
    const val viewModel =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleViewModel}"
}
object Android {
    const val androidCore = "androidx.core:core-ktx:${Versions.ktx}"
}

object Tests {
    const val junit = "junit:junit:${Versions.junit}"
    const val extJunit = "androidx.test.ext:junit:${Versions.extJunit}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
}