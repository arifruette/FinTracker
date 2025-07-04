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
include(":feature:expenses:domain")
include(":core:domain")
include(":feature:income:domain")
include(":feature:balance:domain")
include(":feature:categories:domain")
include(":feature:settings:ui")
include(":feature:history")
include(":feature:history:ui")
include(":feature:history:domain")
include(":core:network")
include(":core:common")
include(":core:data")
include(":feature:categories:data")
include(":feature:settings:domain")
include(":feature:edit-balance")
include(":feature:edit-balance:ui")
include(":feature:edit-balance:domain")
include(":feature:edit-balance:data")
