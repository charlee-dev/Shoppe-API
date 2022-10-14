val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project

plugins {
    application
    kotlin("jvm") version "1.7.20"
    id("io.ktor.plugin") version "2.1.2"
    id("com.github.johnrengelman.shadow") version "6.1.0"
    id("com.google.cloud.tools.appengine") version "2.4.2"
    id("org.jmailen.kotlinter") version "3.12.0"
}

group = "com.digitaldesigns.shoppe.api"
version = "0.0.1"
application {
    mainClass.set("com.digitaldesigns.shoppe.api.ApplicationKt")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    google()
    mavenCentral()
}

val ktorVersion = "2.1.2"
val bCryptVersion = "0.9.0"
val kmongoVersion = "4.7.0"
val logbackVersion = "1.2.9"
val koinVersion = "3.2.2"
val konfigVersion = "1.6.10.0"
val kermitVersion = "1.1.3"
val expediaVersion = "6.2.5"
val mockkVersion = "1.12.4"

dependencies {
        implementation("io.ktor:ktor-server-core:$ktorVersion")
        implementation("io.ktor:ktor-server-netty:$ktorVersion")
        implementation("io.ktor:ktor-server-auth:$ktorVersion")
        implementation("io.ktor:ktor-server-auth-jwt:$ktorVersion")
        implementation("at.favre.lib:bcrypt:$bCryptVersion")
        implementation("org.litote.kmongo:kmongo:$kmongoVersion")
        implementation("ch.qos.logback:logback-classic:$logbackVersion")
        implementation("com.expediagroup:graphql-kotlin-server:$expediaVersion")
        implementation("io.insert-koin:koin-ktor:$koinVersion")
        implementation("io.insert-koin:koin-logger-slf4j:$koinVersion")
        implementation("co.touchlab:kermit:$kermitVersion")
        implementation("com.natpryce:konfig:$konfigVersion")

        testImplementation(kotlin("test-common"))
        testImplementation("io.insert-koin:koin-test:$koinVersion")
        testImplementation("io.mockk:mockk:$mockkVersion")
        testImplementation("org.litote.kmongo:kmongo-core-tests:$kmongoVersion")
        testImplementation("org.amshove.kluent:kluent:1.68")
        testImplementation("io.ktor:ktor-server-test-host:$ktorVersion")
        testImplementation("io.ktor:ktor-server-tests:$ktorVersion")
}

kotlinter {
    ignoreFailures = false
    reporters = arrayOf("checkstyle", "plain")
    experimentalRules = false
    disabledRules = arrayOf("trailing-comma-on-declaration-site")
}
