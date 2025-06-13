pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
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

rootProject.name = "FinTracker"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

include(":app")
include(":navigation")
include(":core")
include(":core:ui")
include(":feature")
include(":feature:expenses")
include(":feature:expenses:ui")
include(":feature:income")
include(":feature:income:ui")
include(":feature:balance")
include(":feature:categories")
include(":feature:balance:ui")
include(":feature:categories:ui")
include(":feature:settings")
include(":feature:settings:ui")
include(":core:common")
include(":feature:expenses:domain")
include(":core:domain")
include(":feature:income:domain")
