allprojects {
    group = "by.sportliner.lk"
    version = getVersionProperties().getProperty("version")

    configurations.all {
        resolutionStrategy.cacheChangingModulesFor(0, "seconds")
    }
}

fun getVersionProperties(): java.util.Properties {
    val result = java.util.Properties()
    java.io.FileInputStream(file("version.txt")).use { result.load(it) }
    return result;
}
