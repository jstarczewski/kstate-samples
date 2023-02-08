pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        mavenLocal()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        mavenLocal()
    }
}

rootProject.name = "kstate-samples"
include(":android")
include(":common")
include(":state")
include(":feature:saveable")
include(":feature:obtainable")
