private object Versions {
    // Libraries
    const val androidToolsBuildGradle = "7.2.0-beta04"
    const val kotlin = "1.6.10"
    const val kotlinxSerialization = "1.3.2"
    const val material = "1.5.0"
    const val koin = "3.1.5"

    // test instrumentation
    const val androidTestCore = "1.4.0"
    const val karumiShot = "5.13.0"
}

object PublicVersions {
    const val kotlin = Versions.kotlin
    const val ktlint = "0.45.1"
    const val detekt = "1.19.0"
    const val kover = "0.5.0"
}

object BuildVersions {
    const val platformVersion = 32
    const val compileSdkVersion = platformVersion
    const val targetSdkVersion = 32
    const val buildToolsVersion = "32.0.0"
    const val minSdkVersion = 23
}

object Libraries {
    const val kotlinxSerializationJson =
        "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.kotlinxSerialization}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val koinAndroid = "io.insert-koin:koin-android:${Versions.koin}"
    const val koinCore = "io.insert-koin:koin-core:${Versions.koin}"
}

object TestLibraries {
    const val androidTestRunner = "androidx.test:runner:${Versions.androidTestCore}"
    const val androidTestCoreKtx = "androidx.test:core-ktx:${Versions.androidTestCore}"
}

object GradlePlugin {
    const val androidToolsBuildGradle =
        "com.android.tools.build:gradle:${Versions.androidToolsBuildGradle}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val kotlinSerializationPlugin =
        "org.jetbrains.kotlin:kotlin-serialization:${Versions.kotlin}"
    const val karumiShotPlugin = "com.karumi:shot:${Versions.karumiShot}"
}