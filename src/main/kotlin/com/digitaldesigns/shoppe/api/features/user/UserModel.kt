package com.digitaldesigns.shoppe.api.features.user

import com.digitaldesigns.shoppe.api.domain.models.Model
import com.digitaldesigns.shoppe.api.domain.util.Constants
import com.digitaldesigns.shoppe.api.domain.util.encrypt
import com.digitaldesigns.shoppe.api.domain.util.generateId
import com.digitaldesigns.shoppe.api.domain.util.trimWhitespaces
import com.digitaldesigns.shoppe.api.graphql.GraphQLDesc
import com.expediagroup.graphql.generator.annotations.GraphQLDescription
import com.expediagroup.graphql.generator.annotations.GraphQLIgnore
import graphql.GraphQLException
import io.ktor.server.auth.Principal
import io.ktor.util.date.getTimeMillis

@GraphQLDescription(GraphQLDesc.User.model)
data class UserModel(
    @GraphQLDescription(GraphQLDesc.User.id) override val id: String = generateId(),
    @GraphQLDescription(GraphQLDesc.User.email) var email: String,
    @GraphQLIgnore var hashedPass: ByteArray,
    @GraphQLDescription(GraphQLDesc.User.displayName) var displayName: String = "",
    @GraphQLDescription(GraphQLDesc.User.userHandle) var userHandle: String = "",
    @GraphQLDescription(GraphQLDesc.User.imageUrl) var imageUrl: String = "",
    @GraphQLDescription(GraphQLDesc.User.firstName) var firstName: String = "",
    @GraphQLDescription(GraphQLDesc.User.lastName) var lastName: String = "",
    @GraphQLDescription(GraphQLDesc.User.locale) var locale: String = "",
    @GraphQLDescription(GraphQLDesc.User.dateCreated) var dateCreated: String = getTimeMillis().toString(),
    @GraphQLDescription(GraphQLDesc.User.lastModified) var lastModified: String = dateCreated,
) : Model, Principal {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as UserModel

        if (id != other.id) return false
        if (email != other.email) return false
        if (!hashedPass.contentEquals(other.hashedPass)) return false
        if (displayName != other.displayName) return false
        if (imageUrl != other.imageUrl) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + email.hashCode()
        result = 31 * result + hashedPass.contentHashCode()
        result = 31 * result + displayName.hashCode()
        result = 31 * result + imageUrl.hashCode()
        return result
    }

    fun toMinimal() = UserMinimal(
        id = id,
        displayName = displayName,
        imageUrl = imageUrl
    )
}

@GraphQLDescription(GraphQLDesc.User.input)
data class UserUpdateInput(
    @GraphQLDescription(GraphQLDesc.User.email) val email: String,
    @GraphQLDescription(GraphQLDesc.User.password) val password: String,
    @GraphQLDescription(GraphQLDesc.User.displayName) val displayName: String,
    @GraphQLDescription(GraphQLDesc.User.userHandle) var userHandle: String = "",
    @GraphQLDescription(GraphQLDesc.User.imageUrl) var imageUrl: String = "",
    @GraphQLDescription(GraphQLDesc.User.firstName) var firstName: String = "",
    @GraphQLDescription(GraphQLDesc.User.lastName) var lastName: String = "",
    @GraphQLDescription(GraphQLDesc.User.locale) var locale: String = "",
) {
    fun validate() {
        email.trimWhitespaces().ifBlank { throw GraphQLException(Constants.Messages.EMAIL_BLANK) }
    }

    fun toUser(userId: String) = UserModel(
        id = userId,
        email = email,
        hashedPass = password.encrypt(),
        displayName = displayName,
        userHandle = userHandle, // TODO: add check if handle exists
        imageUrl = imageUrl,
        firstName = firstName,
        lastName = lastName,
        locale = locale,
    )
}

@GraphQLDescription(GraphQLDesc.User.profile)
data class UserProfile(
    @GraphQLDescription(GraphQLDesc.User.model) val user: UserModel,
)

@GraphQLDescription(GraphQLDesc.User.minimal)
data class UserMinimal(
    @GraphQLDescription(GraphQLDesc.User.id) val id: String,
    @GraphQLDescription(GraphQLDesc.User.displayName) val displayName: String,
    @GraphQLDescription(GraphQLDesc.User.imageUrl) val imageUrl: String,
)
