package com.digitaldesigns.shoppe.api.graphql

import co.touchlab.kermit.Logger
import com.expediagroup.graphql.server.execution.GraphQLRequestParser
import com.expediagroup.graphql.server.types.GraphQLServerRequest
import com.fasterxml.jackson.databind.ObjectMapper
import io.ktor.server.request.ApplicationRequest
import io.ktor.server.request.receiveText
import java.io.IOException

class GraphQLRequestParser(
    private val mapper: ObjectMapper,
) : GraphQLRequestParser<ApplicationRequest> {

    override suspend fun parseRequest(request: ApplicationRequest): GraphQLServerRequest = try {
        val rawRequest = request.call.receiveText()
        Logger.v("✉️ RECEIVED = $rawRequest")
        mapper.readValue(rawRequest, GraphQLServerRequest::class.java)
    } catch (e: IOException) {
        throw IOException("Unable to parse GraphQL payload.")
    }
}
