import com.android.build.api.dsl.ManagedVirtualDevice

plugins {
    id("com.android.application")
    kotlin("android")
    id("shot")
}

android {
    namespace = "siarhei.luskanau.kmm.android"
    compileSdk = libs.versions.android.build.compileSdk.get().toInt()
    defaultConfig {
        minSdk = libs.versions.android.build.minSdk.get().toInt()
        targetSdk = libs.versions.android.build.targetSdk.get().toInt()
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
        animationsDisabled = true
        emulatorSnapshots {
            enableForTestFailures = false
        }
        managedDevices.devices.create<ManagedVirtualDevice>("managedVirtualDevice") {
            device = "Pixel 2"
            apiLevel = 33
        }
    }
    packagingOptions.resources.excludes.addAll(
        listOf(
            "META-INF/AL2.0",
            "META-INF/LGPL2.1"
        )
    )
    compileOptions {
        sourceCompatibility = JavaVersion.valueOf(libs.versions.build.javaVersion.get())
        targetCompatibility = JavaVersion.valueOf(libs.versions.build.javaVersion.get())
    }
    kotlinOptions {
        jvmTarget = libs.versions.build.jvmTarget.get()
    }
}

dependencies {
    implementation(project(":shared"))
    implementation(libs.koinAndroid)
    implementation(libs.material)

    testImplementation(kotlin("test"))

    androidTestImplementation(kotlin("test"))
    androidTestImplementation(libs.androidTestRunner)
    androidTestImplementation(libs.androidTestCoreKtx)
}
