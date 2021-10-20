plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdkVersion(BuildVersions.compileSdkVersion)
    buildToolsVersion = BuildVersions.buildToolsVersion
    defaultConfig {
        minSdkVersion(BuildVersions.minSdkVersion)
        targetSdkVersion(BuildVersions.targetSdkVersion)
        applicationId = "siarhei.luskanau.kmm.android"
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
//        emulatorSnapshots {
//            enableForTestFailures = true
//        }
//        devices.create<com.android.build.api.dsl.ManagedVirtualDevice>("testEmulator28") {
//            device = "Nexus 6"
//            apiLevel = 28
//            systemImageSource = "google"
//            abi = "x86"
//        }
    }
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
