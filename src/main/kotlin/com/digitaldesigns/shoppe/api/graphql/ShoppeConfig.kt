package com.digitaldesigns.shoppe.api.graphql

import com.natpryce.konfig.ConfigurationProperties
import com.natpryce.konfig.EnvironmentVariables
import com.natpryce.konfig.Key
import com.natpryce.konfig.overriding
import com.natpryce.konfig.stringType
import java.io.File

object ShoppeConfig {
    private val configuration = ConfigurationProperties.systemProperties() overriding
            EnvironmentVariables() overriding
            ConfigurationProperties.fromFile(File("/Users/adrianwitaszak/defaults.properties"))

    val port: String = System.getenv("PORT") ?: configuration[Key("shoppe.server.port", stringType)]
    val jwtSecret: String =
        System.getenv("JWT_SECRET") ?: configuration[Key("shoppe.server.jwt.secret", stringType)]
    val mongoUri: String =
        System.getenv("MONGO_URI") ?: configuration[Key("shoppe.server.mongo", stringType)]
}
