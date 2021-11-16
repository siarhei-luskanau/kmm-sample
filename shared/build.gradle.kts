import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("com.android.library")
    id("com.chromaticnoise.multiplatform-swiftpackage") version PublicVersions.multiplatformSwiftpackage
}

version = "1.0.0"

kotlin {
    multiplatformSwiftPackage {
        packageName("KotlinMultiplatformSPExample")
        swiftToolsVersion("5.3")
        targetPlatforms {
            iOS { v("11") }
        }
        outputDirectory(File(buildDir, "spm"))
    }

    android()
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
                implementation(Libraries.kotlinxSerializationJson)
                implementation(Libraries.koinCore)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(Libraries.material)
            }
        }
        val androidTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
       val androidAndroidTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation(TestLibraries.androidTestRunner)
                implementation(TestLibraries.androidTestCoreKtx)
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
    compileSdk = BuildVersions.compileSdkVersion
    buildToolsVersion = BuildVersions.buildToolsVersion
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = BuildVersions.minSdkVersion
        targetSdk = BuildVersions.targetSdkVersion
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}

val packForXcode by tasks.creating(Sync::class) {
    group = "build"
    val mode = System.getenv("CONFIGURATION") ?: "DEBUG"
    val sdkName = System.getenv("SDK_NAME") ?: "iphonesimulator"
    val targetName = "ios" + if (sdkName.startsWith("iphoneos")) "Arm64" else "X64"
    val framework =
        kotlin.targets.getByName<KotlinNativeTarget>(targetName).binaries.getFramework(mode)
    inputs.property("mode", mode)
    dependsOn(framework.linkTask)
    val targetDir = File(buildDir, "xcode-frameworks")
    from({ framework.outputDirectory })
    into(targetDir)
}
tasks.getByName("build").dependsOn(packForXcode)
