plugins {
    kotlin("jvm") version "1.9.22"
}


group = "com.github.wellusion"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.3")

    // testImplementation("org.junit.jupiter:junit-jupiter:5.4.2")
    testImplementation("org.jetbrains.kotlin:kotlin-test")

    // testImplementation("junit", "junit", junitVer)
    // testImplementation(kotlin("test-junit"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}