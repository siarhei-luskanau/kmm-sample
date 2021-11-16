buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(GradlePlugin.kotlinGradlePlugin)
        classpath(GradlePlugin.androidToolsBuildGradle)
        classpath(GradlePlugin.kotlinSerializationPlugin)
    }
}

plugins {
    id("io.gitlab.arturbosch.detekt").version(PublicVersions.detekt)
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