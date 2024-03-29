import java.util.Properties
import org.apache.tools.ant.taskdefs.condition.Os

val ciGradleGroup = "CI_GRADLE"

tasks.register("ciLint") {
    group = ciGradleGroup
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
    group = ciGradleGroup
    doLast {
        gradlew(
            "clean",
            "koverVerify",
            "koverXmlReport",
            "koverHtmlReport"
        )
    }
}

tasks.register("ciBuildApp") {
    group = ciGradleGroup
    doLast {
        gradlew(
            "clean",
            "assembleDebug"
        )
    }
}

tasks.register("ciEmulator") {
    group = ciGradleGroup
    doLast {
        // gradlew("executeScreenshotTests", "-Precord")
        gradlew(
            "managedVirtualDeviceCheck",
            "-Pandroid.testoptions.manageddevices.emulator.gpu=swiftshader_indirect"
        )
        gradlew("cleanManagedDevices")
    }
}

fun gradlew(vararg tasks: String, addToSystemProperties: Map<String, String>? = null) {
    exec {
        executable = File(
            project.rootDir,
            if (Os.isFamily(Os.FAMILY_WINDOWS)) "gradlew.bat" else "gradlew"
        )
            .also { it.setExecutable(true) }
            .absolutePath
        args = mutableListOf<String>().also { mutableArgs ->
            mutableArgs.addAll(tasks)
            addToSystemProperties?.toList()?.map { "-D${it.first}=${it.second}" }?.let {
                mutableArgs.addAll(it)
            }
            mutableArgs.add("--stacktrace")
        }
        val sdkDirPath = Properties().apply {
            val propertiesFile = File(rootDir, "local.properties")
            if (propertiesFile.exists()) {
                load(propertiesFile.inputStream())
            }
        }.getProperty("sdk.dir")
        if (sdkDirPath != null) {
            val platformToolsDir = "$sdkDirPath${java.io.File.separator}platform-tools"
            val pahtEnvironment = System.getenv("PATH").orEmpty()
            if (!pahtEnvironment.contains(platformToolsDir)) {
                environment = environment.toMutableMap().apply {
                    put("PATH", "$platformToolsDir:$pahtEnvironment")
                }
            }
        }
        if (System.getenv("JAVA_HOME") == null) {
            System.getProperty("java.home")?.let { javaHome ->
                environment = environment.toMutableMap().apply {
                    put("JAVA_HOME", javaHome)
                }
            }
        }
        if (System.getenv("ANDROID_HOME") == null) {
            environment = environment.toMutableMap().apply {
                put("ANDROID_HOME", "$sdkDirPath")
            }
        }
        println("commandLine: ${this.commandLine}")
    }.apply { println("ExecResult: $this") }
}
