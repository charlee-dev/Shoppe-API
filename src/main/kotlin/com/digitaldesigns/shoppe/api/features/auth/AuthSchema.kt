package com.digitaldesigns.shoppe.api.features.auth

import com.digitaldesigns.shoppe.api.graphql.GraphQLDesc
import com.expediagroup.graphql.generator.annotations.GraphQLDescription
import com.expediagroup.graphql.server.operations.Mutation
import graphql.GraphQLException
import org.koin.java.KoinJavaComponent.inject

class AuthSchema {
    @GraphQLDescription("Authentication mutations")
    class Mutations : Mutation {
        private val authService: AuthService by inject(AuthService::class.java)

        @GraphQLDescription("Signs in user with email and password, no header needed.")
        @Suppress("unused")
        @Throws(GraphQLException::class)
        fun signIn(
            @GraphQLDescription(GraphQLDesc.Auth.Input.model)
            authInput: AuthInput,
        ): AuthResponse {
            return authService.signIn(authInput)
        }

        @GraphQLDescription("Signs up user with email and password, no header needed.")
        @Suppress("unused")
        @Throws(GraphQLException::class)
        fun signUp(
            @GraphQLDescription(GraphQLDesc.Auth.Input.model)
            authInput: AuthInput,
        ): AuthResponse {
            return authService.signUp(authInput)
        }
    }
}
