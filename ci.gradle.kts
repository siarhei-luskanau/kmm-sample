import org.apache.tools.ant.taskdefs.condition.Os

val CI_GRADLE = "CI_GRADLE"

tasks.register("ciLint") {
    group = CI_GRADLE
    doLast {
        gradlew(
            "clean",
            "ktlintCheck",
            "detekt",
            "lintDebug"
        )
    }
}

tasks.register("ciUnitTest") {
    group = CI_GRADLE
    doLast {
        gradlew(
            "clean",
            "koverVerify",
            "koverReport"
        )
    }
}

tasks.register("ciBuildApp") {
    group = CI_GRADLE
    doLast {
        gradlew(
            "clean",
            "assembleDebug"
        )
    }
}

tasks.register("ciEmulator") {
    group = CI_GRADLE
    doLast {
        mutableListOf(
            "managedVirtualDeviceCheck",
            "-Pandroid.testoptions.manageddevices.emulator.gpu=swiftshader_indirect"
            // ":androidApp:executeScreenshotTests"
        ).also {
            if (System.getenv("CI").isNullOrEmpty()) it.add("-Precord")
        }.also {
            gradlew(*it.toTypedArray())
        }
    }
}

fun gradlew(vararg tasks: String, addToEnvironment: Map<String, String>? = null) {
    exec {
        val gradlePath = File(
            project.rootDir,
            platformExecutable(name = "gradlew", ext = "bat")
        ).absolutePath
        commandLine = mutableListOf<String>().apply {
            add(gradlePath)
            addAll(tasks)
            add("--stacktrace")
        }
        addToEnvironment?.let {
            environment = environment.orEmpty().toMutableMap().apply { putAll(it) }
        }
        println("commandLine: ${this.commandLine}")
    }.apply { println("ExecResult: $this") }
}

fun platformExecutable(name: String, ext: String = "exe"): String =
    if (Os.isFamily(Os.FAMILY_WINDOWS)) {
        "$name.$ext"
    } else {
        name
    }
