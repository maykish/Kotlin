import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

buildscript {
    repositories {
        mavenCentral()
        jcenter()
    }

    dependencies {
        classpath("org.junit.platform:junit-platform-gradle-plugin:1.0.1")
    }
}

plugins {
    kotlin("jvm") version "1.4.20"
    id("com.github.johnrengelman.shadow") version "5.1.0"
    //id("org.jetbrains.kotlin.plugin.serialization") version "1.2"
}

repositories {
    jcenter()
    maven(url="https://dl.bintray.com/anysolo/edu")
    maven(url="https://jitpack.io")
}

dependencies {
    compile(gradleApi())
    compile(kotlin("stdlib"))
    compile(kotlin("stdlib-jdk8"))
    compile(kotlin("reflect"))
    //implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.2.1")
    implementation("com.github.jkcclemens:khttp:0.1.0")
}

tasks.withType<ShadowJar>() {
    manifest {
        attributes["Main-Class"] = "myapp.Weather_apiKt"
    }
}

