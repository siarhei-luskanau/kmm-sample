buildscript {
    dependencies {
        classpath(libs.karumiShotPlugin)
    }
}

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.multiplatform) apply false
    alias(libs.plugins.kotlin.plugin.serialization) apply false
    alias(libs.plugins.detekt) apply false
    alias(libs.plugins.kover)
}

apply(from = "$rootDir/ci.gradle.kts")
apply(from = "$rootDir/ktlint.gradle.kts")

allprojects {
    apply(plugin = "io.gitlab.arturbosch.detekt")
}

tasks.register("clean").configure {
    delete("build")
}
