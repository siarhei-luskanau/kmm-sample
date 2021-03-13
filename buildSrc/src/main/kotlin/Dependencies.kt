private object Versions {
    // Libraries
    const val androidToolsBuildGradle = "4.2.0-beta06"
    const val desugar = "1.1.5"
    const val kotlin = "1.4.31"
    const val kotlinxCoroutines = "1.4.3"
    const val kotlinxSerialization = "1.1.0"
    const val navigation = "2.3.4"
    const val material = "1.3.0"
    const val androidJunit5 = "1.7.1.1"
    const val googleServices = "4.3.5"
    const val koin = "3.0.1-beta-1"
}

object PublicVersions {
    const val kotlin = Versions.kotlin
    const val ktlint = "0.40.0"
    const val detekt = "1.15.0"
}

object BuildVersions {
    const val platformVersion = 30
    const val compileSdkVersion = platformVersion
    const val targetSdkVersion = 30
    const val buildToolsVersion = "30.0.3"
    const val cmdlineToolsVersion = "3.0"
    const val minSdkVersion = 24
}

object Libraries {
    const val desugarJdkLibs = "com.android.tools:desugar_jdk_libs:${Versions.desugar}"
    const val kotlinStdlibJdk8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
    const val kotlinReflect = "org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlin}"
    const val kotlinxCoroutinesCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinxCoroutines}"
    const val kotlinxSerializationJson =
        "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.kotlinxSerialization}"
    const val navigationFragmentKtx =
        "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigationUiKtx = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val koinAndroid = "io.insert-koin:koin-android:${Versions.koin}"
}

object GradlePlugin {
    const val androidToolsBuildGradle =
        "com.android.tools.build:gradle:${Versions.androidToolsBuildGradle}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val navigationSafeArgsGradlePlugin =
        "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation}"
    const val androidJunit5Plugin =
        "de.mannodermaus.gradle.plugins:android-junit5:${Versions.androidJunit5}"
    const val googleServicePlugin = "com.google.gms:google-services:${Versions.googleServices}"
}