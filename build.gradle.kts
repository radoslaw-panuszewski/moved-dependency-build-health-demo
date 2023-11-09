plugins {
    kotlin("jvm") version "1.9.20"
    id("com.autonomousapps.dependency-analysis") version "1.25.0"
}

group = "pl.semidude.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.1")
    testImplementation("com.github.tomakehurst:wiremock-standalone:3.0.1")
    testImplementation("io.rest-assured:rest-assured:5.3.2")

    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.10.1")
}

dependencyAnalysis {
    issues {
        all {
            onUsedTransitiveDependencies {
                severity("ignore")
            }
        }
    }
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}