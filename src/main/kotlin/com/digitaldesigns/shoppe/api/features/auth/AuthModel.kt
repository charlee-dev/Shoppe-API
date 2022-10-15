package com.digitaldesigns.shoppe.api.features.auth

import com.digitaldesigns.shoppe.api.domain.util.Constants
import com.digitaldesigns.shoppe.api.domain.util.trimWhitespaces
import com.digitaldesigns.shoppe.api.features.user.UserMinimal
import com.digitaldesigns.shoppe.api.features.user.emailDescription
import com.digitaldesigns.shoppe.api.features.user.passwordDescription
import com.digitaldesigns.shoppe.api.features.user.userMinimalDescription
import com.expediagroup.graphql.generator.annotations.GraphQLDescription
import graphql.GraphQLException

@GraphQLDescription(authInputDescription)
data class AuthInput(
    @GraphQLDescription(emailDescription)
    val email: String,
    @GraphQLDescription(passwordDescription)
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

@GraphQLDescription("AuthResponse:\n- token: String\n- user: UserMinimal")
data class AuthResponse(
    @GraphQLDescription(tokenDescription)
    val token: String,
    @GraphQLDescription(userMinimalDescription)
    val user: UserMinimal,
)

const val authInputDescription = "AuthInput:\n- email: String\n- password: String"
const val tokenDescription = "Authorization token, without `Bearer ` prefix"
