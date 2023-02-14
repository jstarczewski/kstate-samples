pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
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
