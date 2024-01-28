import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("jvm") version "1.9.21"
    kotlin("plugin.serialization") version "1.9.21"
    id("org.jetbrains.compose") version "1.5.11"
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

kotlin {
    jvmToolchain(21)
}

group = "hu.gecsevar"
version = "1.0.0"

repositories {
    mavenCentral()
}

val exposedVersion="0.46.0"
val ktorVersion="2.3.4"
val voyagerVersion = "1.0.0"

dependencies {
    // Note, if you develop a library, you should use compose.desktop.common.
    // compose.desktop.currentOs should be used in launcher-sourceSet
    // (in a separate module for demo project and in testMain).
    // With compose.desktop.common you will also lose @Preview functionality
    implementation(compose.desktop.currentOs)
    implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.1")
    // Kotlin Exposed SQL DSL DAO - Migration
    implementation("org.jetbrains.exposed:exposed-core:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-dao:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-jdbc:$exposedVersion")
    // https://mvnrepository.com/artifact/org.jetbrains.exposed/exposed-kotlin-datetime
    implementation("org.jetbrains.exposed:exposed-kotlin-datetime:$exposedVersion")
    // Sqlite
    implementation("org.xerial:sqlite-jdbc:3.42.0.0")
    implementation("org.slf4j:slf4j-nop:2.0.7")
    // https://mvnrepository.com/artifact/de.siegmar/fastcsv
    implementation("de.siegmar:fastcsv:3.0.0")

}

compose.desktop {
    application {
        mainClass = "MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "CatalogSynchronizer"
            packageVersion = "1.0.0"
        }
    }
}
