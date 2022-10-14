package com.digitaldesigns.shoppe.api.graphql

import co.touchlab.kermit.Logger
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.ApplicationCall
import io.ktor.server.response.respond

class KtorServer {
    private val mapper = jacksonObjectMapper()
    private val ktorGraphQLServer = getGraphQLServer(mapper)

    suspend fun handle(applicationCall: ApplicationCall) {
        Logger.v("✉️ RECEIVED = $applicationCall")
        val result = ktorGraphQLServer.execute(applicationCall.request)
        Logger.v("🧾 RETURNED = $result")
        if (result != null) {
            val json = mapper.writeValueAsString(result)
            applicationCall.response.call.respond(json)
        } else {
            applicationCall.response.call.respond(HttpStatusCode.BadRequest, "Invalid request")
        }
    }
}
