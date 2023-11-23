pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

rootProject.name = "sportliner-lk"

include("sportliner-lk-core")
include("sportliner-lk-ednpoint")
include("sportliner-lk-endpoint-api")
include("sportliner-lk-database")
include("sportliner-lk-webapp")
