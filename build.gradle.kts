import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.10"
    id("fabric-loom") version "1.0-SNAPSHOT"
}

group = "com.adoneko"
version = "1.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17

    withSourcesJar()
}

repositories {
    mavenCentral()
}

dependencies {
    val minecraft_version: String by project.extra
    val yarn_mappings: String by project.extra
    val loader_version: String by project.extra
    val fabric_version: String by project.extra
    val fabric_kotlin_version: String by project.extra

    minecraft("com.mojang:minecraft:${minecraft_version}")
    mappings("net.fabricmc:yarn:${yarn_mappings}:v2")
    modImplementation("net.fabricmc:fabric-loader:${loader_version}")

    modImplementation("net.fabricmc.fabric-api:fabric-api:${fabric_version}")
    modImplementation("net.fabricmc:fabric-language-kotlin:${fabric_kotlin_version}")
}

tasks {
    val mod_version: String by project.extra
    val fabric_kotlin_version: String by project.extra

    withType<KotlinCompile> {
        kotlinOptions.jvmTarget = JavaVersion.VERSION_17.toString()
    }

    processResources {
        filesMatching("fabric.mod.json") {
            expand(mapOf(
                "version" to mod_version,
                "fabric_kotlin_version" to fabric_kotlin_version
            ))
        }
    }
}

