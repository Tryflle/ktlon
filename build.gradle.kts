plugins {
    kotlin("jvm") version "1.8.21"
    kotlin("plugin.serialization") version "1.9.21"
    id("com.github.weave-mc.weave-gradle") version "649dba7468"
}

group = "me.tryfle"
version = "1.0"

minecraft.version("1.8.9")

repositories {
    maven("https://jitpack.io")
    maven("https://repo.spongepowered.org/maven/")
}

dependencies {
    compileOnly("com.github.weave-mc:weave-loader:v0.2.4")
    compileOnly("org.spongepowered:mixin:0.8.5")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.1")
}

tasks.compileJava {
    options.release.set(17)
}
