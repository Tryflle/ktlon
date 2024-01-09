plugins {
    kotlin("jvm") version "1.9.21"
    kotlin("plugin.serialization") version "1.9.21"
    id("com.github.weave-mc.weave-gradle") version "649dba7468"
    id ("java")
    id ("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "me.tryfle"
version = "1.1"

minecraft.version("1.8.9")

repositories {
    maven("https://jitpack.io")
    maven("https://repo.spongepowered.org/maven/")
}

dependencies {
    compileOnly("com.github.weave-mc:weave-loader:v0.2.4")
    compileOnly("org.spongepowered:mixin:0.8.5")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
}

tasks.compileJava {
    options.release.set(17)
}