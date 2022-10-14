package com.digitaldesigns.shoppe.api

import com.digitaldesigns.shoppe.api.plugins.configureKoin
import com.digitaldesigns.shoppe.api.plugins.configureRouting
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

fun main() {
    embeddedServer(Netty, port = 8080) {
        configureKoin()
        configureRouting()
    }.start(wait = true)
}
