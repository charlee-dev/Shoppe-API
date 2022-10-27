package com.digitaldesigns.shoppe.api.features.auth

import com.digitaldesigns.shoppe.api.domain.util.Constants
import com.digitaldesigns.shoppe.api.domain.util.trimWhitespaces
import com.digitaldesigns.shoppe.api.features.user.UserMinimal
import com.digitaldesigns.shoppe.api.graphql.GraphQLDesc
import com.expediagroup.graphql.generator.annotations.GraphQLDescription
import graphql.GraphQLException

@GraphQLDescription(GraphQLDesc.Auth.Input.model)
data class AuthInput(
    @GraphQLDescription(GraphQLDesc.Auth.Input.email)
    val email: String,
    @GraphQLDescription(GraphQLDesc.Auth.Input.password)
    val password: String,
) {
    fun validate() {
        email.trimWhitespaces().ifBlank { throw GraphQLException(Constants.Messages.EMAIL_BLANK) }
        password.trimWhitespaces().ifBlank {
            throw GraphQLException(
                Constants.Messages.PASSWORD_BLANK
            )
        }
    }
}

@GraphQLDescription(GraphQLDesc.Auth.Input.model)
data class AuthResponse(
    @GraphQLDescription(GraphQLDesc.Auth.Response.token)
    val token: String,
    @GraphQLDescription(GraphQLDesc.Auth.Response.user)
    val user: UserMinimal,
)
