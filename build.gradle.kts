val kotlinVersion = "1.3.41"

buildscript {
    val kotlinVersion = "1.3.41"

    repositories {
        mavenCentral()
        jcenter()
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
        classpath("org.junit.platform:junit-platform-gradle-plugin:1.0.1")
    }
}

plugins {
    kotlin("jvm") version "1.3.41"
}

repositories {
    jcenter()
    maven(url="https://dl.bintray.com/anysolo/edu")
}

dependencies {
    compile(gradleApi())
    compile(kotlin("stdlib", kotlinVersion))
    compile(kotlin("stdlib-jdk8"))
    compile(kotlin("reflect", kotlinVersion))
    compile("com.anysolo:toyGraphics:0.7.0")
}
