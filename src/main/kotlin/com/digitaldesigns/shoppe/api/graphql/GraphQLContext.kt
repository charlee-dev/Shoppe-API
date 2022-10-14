package com.digitaldesigns.shoppe.api.graphql

import com.digitaldesigns.shoppe.api.domain.util.Constants.Messages.NO_AUTH_HEADER
import com.digitaldesigns.shoppe.api.features.auth.JwtService
import com.expediagroup.graphql.generator.execution.GraphQLContext
import com.expediagroup.graphql.server.execution.GraphQLContextFactory
import io.ktor.http.HttpHeaders
import io.ktor.server.request.ApplicationRequest
import org.koin.java.KoinJavaComponent.inject

@Suppress("DEPRECATION")
class GraphQLContext : GraphQLContextFactory<GraphQLContext, ApplicationRequest> {
    private val jwtService: JwtService by inject(JwtService::class.java)

    override suspend fun generateContextMap(request: ApplicationRequest): Map<Any, Any> =
        mutableMapOf<Any, Any>().also { map ->
            request.getAuthHeader()?.let { value ->
                val userId = jwtService.verifyToken(value)
                map["id"] = userId
            }
        }

    private fun ApplicationRequest.getAuthHeader(): String? {
        val header = headers[HttpHeaders.Authorization]
        header?.ifBlank { throw Exception(NO_AUTH_HEADER) }
        return header
    }
}
