package com.digitaldesigns.shoppe.api

import com.digitaldesigns.shoppe.api.graphql.ShoppeConfig
import com.digitaldesigns.shoppe.api.plugins.configureKoin
import com.digitaldesigns.shoppe.api.plugins.configureRouting
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

fun main() {
    embeddedServer(Netty, port = ShoppeConfig.port.toInt()) {
        configureKoin()
        configureRouting()
    }.start(wait = true)
}
