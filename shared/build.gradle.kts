import com.android.build.api.dsl.ManagedVirtualDevice

plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("com.android.library")
}

version = "1.0.0"

kotlin {
    androidTarget()
    ios {
        binaries {
            framework {
                baseName = "shared"
            }
        }
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.kotlinxCoroutinesCore)
                implementation(libs.kotlinxSerializationJson)
                implementation(libs.koinCore)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(libs.material)
            }
        }
        val androidUnitTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidInstrumentedTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation(libs.androidTestRunner)
                implementation(libs.androidTestCoreKtx)
            }
        }
        val iosMain by getting
        val iosTest by getting
    }
}

tasks.withType(AbstractTestTask::class.java) {
    println("AbstractTestTask : $this")
    testLogging.events = setOf(
        org.gradle.api.tasks.testing.logging.TestLogEvent.PASSED,
        org.gradle.api.tasks.testing.logging.TestLogEvent.SKIPPED,
        org.gradle.api.tasks.testing.logging.TestLogEvent.FAILED
    )
}

android {
    namespace = "siarhei.luskanau.kmm.shared"
    compileSdk = libs.versions.android.build.compileSdk.get().toInt()
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = libs.versions.android.build.minSdk.get().toInt()
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.valueOf(libs.versions.build.javaVersion.get())
        targetCompatibility = JavaVersion.valueOf(libs.versions.build.javaVersion.get())
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
}
