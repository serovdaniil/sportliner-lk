import com.github.gradle.node.NodeExtension
import com.github.gradle.node.yarn.task.YarnInstallTask
import com.github.gradle.node.yarn.task.YarnTask

plugins {
    base
    id("com.github.node-gradle.node") version "4.0.0"
    id("org.hidetake.swagger.generator") version "2.19.2"
}

repositories {
    mavenCentral()
}

dependencies {
    swaggerCodegen("org.openapitools:openapi-generator-cli:6.4.0")
}
val NODE_VERSION = "18.18.1"
val YARN_VERSION = "1.22.19"

configure<NodeExtension> {

    // Expects Node.js repository configuration in the settings script
    // See: https://github.com/node-gradle/gradle-node-plugin/issues/134
    download.set(true)
    //distBaseUrl.set(null)

    version.set(NODE_VERSION)
    npmVersion.set("")
    yarnVersion.set(YARN_VERSION)

    workDir.set(file("${rootDir}/.gradle/jstools"))
    npmWorkDir.set(file("${rootDir}/.gradle/jstools"))
    yarnWorkDir.set(file("${rootDir}/.gradle/jstools"))
}

tasks.register<YarnInstallTask>("install") {
}

tasks.register<YarnTask>("compile") {
    dependsOn(tasks.named("install"))

    args.set(listOf("run", "build"))

    environment.set(mapOf(
            // Improve build performance for react-scripts, sacrificing some not actively used features.
            // See details: https://create-react-app.dev/docs/advanced-configuration
            "DISABLE_ESLINT_PLUGIN" to "true",
            "GENERATE_SOURCEMAP" to "false",
            // ---
            // react app properties to pass into build
            "REACT_APP_VERSION" to "${project.version}"
    ));
}

tasks.register<YarnTask>("test") {
    dependsOn(tasks.named("install"))

    args.set(listOf("run", "test"))

    environment.set(mapOf(
            // Improve build performance for react-scripts, sacrificing some not actively used features.
            // See details: https://create-react-app.dev/docs/advanced-configuration
            "DISABLE_ESLINT_PLUGIN" to "true",
            "GENERATE_SOURCEMAP" to "false",
            // ---
            // react app properties to pass into build
            "REACT_APP_VERSION" to "${project.version}"
    ));
}

tasks.register<YarnTask>("start") {
    dependsOn(tasks.named("install"))
    dependsOn(tasks.named("stop"))
    mustRunAfter(tasks.named("stop"))

    args.set(listOf("run", "start"))

    environment.set(mapOf(
            // Improve build performance for react-scripts, sacrificing some not actively used features.
            // See details: https://create-react-app.dev/docs/advanced-configuration
            "DISABLE_ESLINT_PLUGIN" to "true",
            "GENERATE_SOURCEMAP" to "false",
            // ---
            // react app properties to pass into build
            "REACT_APP_VERSION" to "${project.version}"
    ));
}

tasks.register("stop") {
    doLast {
//        try {
//            exec {
//                commandLine = listOf("cmd", "/c", "taskkill /F /IM node.exe")
//                isIgnoreExitValue = true
//            }
//        } catch (e: Exception) {
//            println(e.message)
//        }
        val pattern = "node ${project.projectDir}"
        exec {
            commandLine = listOf("sh", "-c", "pkill -f '${pattern}'")
            isIgnoreExitValue = true
        }
    }
}

tasks.register<Zip>("zip") {
    dependsOn(tasks.named("compile"))

    archiveFileName.set("${project.name}-${project.version}.zip")
    destinationDirectory.set(file("$buildDir"))

    from("$buildDir/dist")
}

tasks.check {
    dependsOn(tasks.named("test"))
}

tasks.assemble {
    dependsOn(tasks.named("zip"))
}

tasks.register("startSportlinerLk") {
    dependsOn(tasks.named("start"))
}

tasks.register("stopSportlinerLk") {
    dependsOn(tasks.named("stop"))
}


project.swaggerSources.register("sportlinerLkAPI") {
    code(delegateClosureOf<org.hidetake.gradle.swagger.generator.GenerateSwaggerCode> {
        val genApiFile = project(":sportliner-lk-endpoint-api").file("src/api/sportliner-lk-endpoint-api.yaml")
        val genConfigFile = project(":sportliner-lk-webapp").file("openapi-generator-config.yaml")
        val genTargetDir = file("$projectDir/src/api")
        val genBuildDir = file("$projectDir/build/generated-swagger/api")

        language = "typescript-fetch"
        inputFile = genApiFile
        configFile = genConfigFile
        outputDir = genBuildDir
        templateDir = file("$rootDir/sportliner-lk-webapp/custom-templates")

        doLast {
            project.delete("$genBuildDir/.openapi-generator")
            project.delete("$genBuildDir/.openapi-generator-ignore")
            project.sync {
                from("$genBuildDir")
                into("$genTargetDir")
            }
        }
    })
}
