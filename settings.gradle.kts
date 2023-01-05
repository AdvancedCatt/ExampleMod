rootProject.name = "ExampleMod"

pluginManagement {
    repositories {
        maven("https://maven.fabricmc.net") { name = "Fabric" }

        mavenLocal()
        gradlePluginPortal()
    }
}