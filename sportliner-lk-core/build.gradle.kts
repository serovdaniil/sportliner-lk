plugins {
    id("java")
    id("org.springframework.boot") version "3.0.5"
    id("io.spring.dependency-management") version "1.1.0"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":sportliner-lk-integration-epos-hgrosh"))

    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.security:spring-security-oauth2-core")
    implementation("org.springframework.security:spring-security-oauth2-jose")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("commons-io:commons-io:1.3.1")

    implementation("commons-codec:commons-codec:1.15")

    implementation("org.openapitools:jackson-databind-nullable:0.2.6")

    // telegram
    implementation("org.telegram:telegrambots-abilities:6.9.0")
    compileOnly("org.projectlombok:lombok:1.18.30")

    runtimeOnly("org.postgresql:postgresql")

}
