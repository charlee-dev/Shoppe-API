package com.digitaldesigns.shoppe.api.graphql

import com.expediagroup.graphql.server.execution.GraphQLRequestHandler
import com.expediagroup.graphql.server.execution.GraphQLServer
import com.fasterxml.jackson.databind.ObjectMapper
import io.ktor.server.request.ApplicationRequest

class KtorGraphQLServer(
    requestParser: GraphQLRequestParser,
    contextFactory: GraphQLContext,
    requestHandler: GraphQLRequestHandler,
) : GraphQLServer<ApplicationRequest>(requestParser, contextFactory, requestHandler)

fun getGraphQLServer(mapper: ObjectMapper): KtorGraphQLServer {
    val requestParser = GraphQLRequestParser(mapper)
    val contextFactory = GraphQLContext()
    val graphQL = getGraphQLObject()
    val requestHandler = GraphQLRequestHandler(graphQL)
    return KtorGraphQLServer(requestParser, contextFactory, requestHandler)
}
