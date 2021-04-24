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
}

tasks.register("clean").configure {
    delete("build")
}