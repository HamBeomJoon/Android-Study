pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "AndroidLab"
include(":app")
include(":ch6_view")
include(":ch7_layout")
include(":ch8_event")
include(":ch9_resource")
include(":ch10_notification")
include(":ch11_jetpack")
