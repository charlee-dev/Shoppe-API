package com.digitaldesigns.shoppe.api.plugins

import com.digitaldesigns.shoppe.api.graphql.KtorServer
import io.ktor.http.ContentType
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.response.respondText
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.routing.routing

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Welcome to the Shoppe!")
        }

        post("graphql") {
            KtorServer().handle(this.call)
        }

        get("playground") {
            this.call.respondText(
                buildPlaygroundHtml("graphql", "subscriptions"),
                ContentType.Text.Html,
            )
        }
    }
}

private fun buildPlaygroundHtml(graphQLEndpoint: String, subscriptionsEndpoint: String) =
    Application::class.java.classLoader.getResource("graphql-playground.html")?.readText()
        ?.replace("\${graphQLEndpoint}", graphQLEndpoint)
        ?.replace("\${subscriptionsEndpoint}", subscriptionsEndpoint)
        ?: throw IllegalStateException("graphql-playground.html cannot be found in the classpath")
