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

allprojects {
    repositories {
        google()
        mavenCentral()
    }
    apply(from = "$rootDir/ktlint.gradle.kts")
}

tasks.register("clean").configure {
    delete("build")
}