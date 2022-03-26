buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(GradlePlugin.kotlinGradlePlugin)
        classpath(GradlePlugin.androidToolsBuildGradle)
        classpath(GradlePlugin.kotlinSerializationPlugin)
        classpath(GradlePlugin.karumiShotPlugin)
    }
}

plugins {
    id("io.gitlab.arturbosch.detekt") version PublicVersions.detekt
    id("org.jetbrains.kotlinx.kover") version PublicVersions.kover
}

apply(from = "$rootDir/ci.gradle.kts")

allprojects {
    repositories {
        google()
        mavenCentral()
    }
    apply(from = "$rootDir/ktlint.gradle.kts")
    apply(plugin = "io.gitlab.arturbosch.detekt")
}

tasks.register("clean").configure {
    delete("build")
}

kover {
    coverageEngine.set(kotlinx.kover.api.CoverageEngine.INTELLIJ)
    // coverageEngine.set(kotlinx.kover.api.CoverageEngine.JACOCO)
}
