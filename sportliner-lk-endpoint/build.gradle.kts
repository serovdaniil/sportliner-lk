plugins {
    id("java")
    id("org.springframework.boot") version "3.0.5"
    id("io.spring.dependency-management") version "1.1.0"
    id("org.hidetake.swagger.generator") version "2.19.2"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":sportliner-lk-core"))

    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-oauth2-resource-server")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.data:spring-data-commons")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.telegram:telegrambots-abilities:6.9.0")

    // for swagger
    compileOnly("jakarta.annotation:jakarta.annotation-api:2.1.1")
    compileOnly("jakarta.validation:jakarta.validation-api:3.0.2")
    compileOnly("com.google.code.findbugs:jsr305:3.0.2")
    compileOnly("io.swagger.core.v3:swagger-annotations:2.2.8")
    compileOnly("org.openapitools:jackson-databind-nullable:0.2.4")
    compileOnly("org.springframework:spring-web")
    compileOnly("org.springframework:spring-context")
    swaggerCodegen("org.openapitools:openapi-generator-cli:6.4.0")
}

project.extensions.findByType<JavaPluginExtension>()?.apply {
    sourceSets.getByName("main") {
        java {
            srcDir("src/main/generated")
        }
    }
}

tasks.withType<ProcessResources>().configureEach {
    filesMatching("application-build.properties") {
        expand(mapOf(
            "application_title" to project.name,
            "application_version" to "${project.version}"
        ))
    }
}

springBoot {
    buildInfo {
        properties {
            excludes.set(setOf("time"))// prevents non-reproducible builds
        }
    }

    // mainClass
    mainClass.set("by.sportliner.lk.endpoint.EndpointApplication")
}

tasks.register("startEndpoint") {
    group = "dev"
    description = "Starts local endpoint server"
    dependsOn(tasks.bootRun)
}

project.swaggerSources.register("endpointApi") {
    code(delegateClosureOf<org.hidetake.gradle.swagger.generator.GenerateSwaggerCode> {
        val packageDirs = "by.sportliner.lk.endpoint.api".replace('.', '/')

        val genApiFile = project(":sportliner-lk-endpoint-api").file("src/api/sportliner-lk-endpoint-api.yaml")
        val genConfigFile = file("$projectDir/openapi-generator-config.yaml")
        val genTargetDir = file("$projectDir/src/main/generated")
        val genBuildDir = file("$projectDir/build/generated-swagger/${"by.sportliner.lk.endpoint.api"}")

        language = "spring"
        library = "spring-boot"
        components = kotlin.collections.listOf("models", "apis")
        additionalProperties = kotlin.collections.mapOf(
            "apiPackage" to "by.sportliner.lk.endpoint.api",
            "modelPackage" to "by.sportliner.lk.endpoint.api"
        )
        inputFile = genApiFile
        configFile = genConfigFile
        outputDir = genBuildDir

        doLast {
            project.sync {
                from("$genBuildDir/$packageDirs")
                into("$genTargetDir/$packageDirs")
            }
        }
    })
}
