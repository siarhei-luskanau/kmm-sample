private object Versions {
    // Libraries
    const val androidToolsBuildGradle = "7.0.0"
    const val kotlin = "1.5.21"
    const val kotlinxCoroutines = "1.5.1-native-mt"
    const val kotlinxSerialization = "1.2.2"
    const val material = "1.4.0"
    const val koin = "3.1.2"

    // test instrumentation
    const val androidTestCore = "1.4.0"
}

object PublicVersions {
    const val kotlin = Versions.kotlin
    const val ktlint = "0.41.0"
    const val detekt = "1.17.1"
    const val multiplatformSwiftpackage = "2.0.3"
}

object BuildVersions {
    const val platformVersion = 31
    const val compileSdkVersion = platformVersion
    const val targetSdkVersion = 31
    const val buildToolsVersion = "30.0.0"
    const val minSdkVersion = 24
}

object Libraries {
    const val kotlinStdlibJdk8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
    const val kotlinReflect = "org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlin}"
    const val kotlinxCoroutinesCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinxCoroutines}"
    const val kotlinxSerializationJson =
        "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.kotlinxSerialization}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val koinAndroid = "io.insert-koin:koin-android:${Versions.koin}"
    const val koinCore = "io.insert-koin:koin-core:${Versions.koin}"
}

object TestLibraries {
    const val androidTestRunner = "androidx.test:runner:${Versions.androidTestCore}"
    const val androidTestCoreKtx = "androidx.test:core-ktx:${Versions.androidTestCore}"
    const val koinTest = "io.insert-koin:koin-test:${Versions.koin}"
}

object GradlePlugin {
    const val androidToolsBuildGradle =
        "com.android.tools.build:gradle:${Versions.androidToolsBuildGradle}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val kotlinSerializationPlugin =
        "org.jetbrains.kotlin:kotlin-serialization:${Versions.kotlin}"
}