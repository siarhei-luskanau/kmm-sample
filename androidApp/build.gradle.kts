plugins {
    id("com.android.application")
    kotlin("android")
    id("shot")
}

android {
    compileSdk = BuildVersions.compileSdkVersion
    buildToolsVersion = BuildVersions.buildToolsVersion
    defaultConfig {
        minSdk = BuildVersions.minSdkVersion
        targetSdk = BuildVersions.targetSdkVersion
        applicationId = "siarhei.luskanau.kmm.android"
        testApplicationId = "siarhei.luskanau.kmm.android.test"
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "com.karumi.shot.ShotTestRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    testOptions {
        unitTests {
            all { test: Test ->
                test.testLogging.events = setOf(
                    org.gradle.api.tasks.testing.logging.TestLogEvent.PASSED,
                    org.gradle.api.tasks.testing.logging.TestLogEvent.SKIPPED,
                    org.gradle.api.tasks.testing.logging.TestLogEvent.FAILED
                )
            }
        }
    }
    packagingOptions.excludes.addAll(
        listOf(
            "META-INF/AL2.0",
            "META-INF/LGPL2.1",
        )
    )
}

dependencies {
    implementation(project(":shared"))
    implementation(Libraries.koinAndroid)
    implementation(Libraries.material)

    testImplementation(kotlin("test"))

    androidTestImplementation(kotlin("test"))
    androidTestImplementation(TestLibraries.androidTestRunner)
    androidTestImplementation(TestLibraries.androidTestCoreKtx)
}
