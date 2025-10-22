plugins {
    kotlin("jvm") version "2.2.20"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("ai.koog:koog-agents:0.5.1")
    implementation("ai.koog:embeddings-llm:0.5.1")
    implementation("ai.koog:embeddings-base:0.5.1")
    implementation("ai.koog:rag-base:0.5.1")
    implementation("ai.koog:vector-storage:0.5.1")

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(22)
}