plugins {
    id("java")
    id("org.hidetake.swagger.generator") version "2.19.2"
    id("org.springframework.boot") version "3.0.5"
    id("io.spring.dependency-management") version "1.1.0"
}

repositories {
    mavenCentral()
}

dependencies {
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


project.swaggerSources.register("epos-hgrosh-Api") {
    code(delegateClosureOf<org.hidetake.gradle.swagger.generator.GenerateSwaggerCode> {
        val genApiFile = project(":sportliner-lk-integration-epos-hgrosh").file("src/main/api/epos-hgrosh-api.yaml")
        val genConfigFile = file("$projectDir/openapi-generator-config.yaml")
        val genTargetDir = file("$projectDir/src/main/generated")
        val genBuildDir = file("$projectDir/build/generated-swagger")

        language = "java"
        library = "resttemplate"
        inputFile = genApiFile
        configFile = genConfigFile
        outputDir = genBuildDir

        doLast {
            project.sync {
                from("$genBuildDir/src/main/generated")
                into(genTargetDir)
            }
        }
    })
}
