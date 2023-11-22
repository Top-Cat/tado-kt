import org.jlleitschuh.gradle.ktlint.reporter.ReporterType

plugins {
    kotlin("jvm") version "1.9.20"
    kotlin("plugin.serialization") version "1.9.20"
    id("org.jlleitschuh.gradle.ktlint") version "11.5.1"
    id("maven-publish")
}

group = "at.topc.tado"
version = System.getenv("BUILD_NUMBER")?.let { "1.0.$it" } ?: "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.apache.httpcomponents:httpasyncclient:4.1.5")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.1")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(16)
}

ktlint {
    version.set("0.50.0")
    reporters {
        reporter(ReporterType.CHECKSTYLE)
    }
}

publishing {
    publications {
        create<MavenPublication>("tadokt") {
            from(components["java"])
        }
    }

    repositories {
        maven {
            name = "reposilite"
            credentials {
                username = System.getenv("MAVEN_USERNAME")
                password = System.getenv("MAVEN_PASSWORD")
            }
            url = uri("https://artifactory.kirkstall.top-cat.me/")
        }
    }
}
