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
    java
	kotlin("jvm") version "1.4.20"
    id("com.github.johnrengelman.shadow") version "5.1.0"
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
	compile("com.fasterxml.jackson.module:jackson-module-kotlin:2.10.0")
	implementation("com.github.jkcclemens:khttp:0.1.0")
	testImplementation("org.junit.jupiter:junit-jupiter:5.5.2")
}

tasks.withType<ShadowJar>() {
    manifest {
        attributes["Main-Class"] = "myapp.Weather_apiKt"
    }
}

tasks.test {
    useJUnitPlatform()
	testLogging {
        events("passed", "skipped", "failed")
    }
}

