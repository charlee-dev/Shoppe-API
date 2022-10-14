package com.digitaldesigns.shoppe.api.graphql

object ShoppeConfig {
    val jwtSecret: String =
        System.getenv("JWT_SECRET") ?: ""
    val mongoUri: String =
        System.getenv("MONGO_URI") ?: ""
}
