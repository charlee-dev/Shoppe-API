package com.digitaldesigns.shoppe.api.features.user

import com.digitaldesigns.shoppe.api.domain.models.Model
import com.digitaldesigns.shoppe.api.domain.util.Constants
import com.digitaldesigns.shoppe.api.domain.util.encrypt
import com.digitaldesigns.shoppe.api.domain.util.generateId
import com.digitaldesigns.shoppe.api.domain.util.trimWhitespaces
import com.digitaldesigns.shoppe.api.features.product.model.createdDateDescription
import com.expediagroup.graphql.generator.annotations.GraphQLDescription
import com.expediagroup.graphql.generator.annotations.GraphQLIgnore
import graphql.GraphQLException
import io.ktor.server.auth.Principal
import io.ktor.util.date.getTimeMillis

@GraphQLDescription(userDescription)
data class UserModel(
    @GraphQLDescription(idDescription)
    override val id: String = generateId(),
    @GraphQLDescription(emailDescription)
    var email: String,
    @GraphQLIgnore
    var hashedPass: ByteArray,
    @GraphQLDescription(displayNameDescription)
    var displayName: String = "",
    @GraphQLDescription(imageUrlDescription)
    var imageUrl: String = "",
    @GraphQLDescription(createdDateDescription)
    var dateCreated: String = getTimeMillis().toString(),
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

@GraphQLDescription(userInputDescription)
data class UserInput(
    @GraphQLDescription(emailDescription)
    val email: String,
    @GraphQLDescription(passwordDescription)
    val password: String,
    @GraphQLDescription(displayNameDescription)
    val displayName: String,
    @GraphQLDescription(imageUrlDescription)
    val imageUrl: String,
) {
    fun validate() {
        email.trimWhitespaces().ifBlank { throw GraphQLException(Constants.Messages.EMAIL_BLANK) }
    }

    fun toUser(userId: String) = UserModel(
        id = userId,
        email = email,
        hashedPass = password.encrypt(),
        displayName = displayName,
        imageUrl = imageUrl
    )
}

@GraphQLDescription(userProfileDescription)
data class UserProfile(
    @GraphQLDescription(userDescription) val user: UserModel,
)

@GraphQLDescription(userMinimalDescription)
data class UserMinimal(
    @GraphQLDescription(idDescription)
    val id: String,
    @GraphQLDescription(displayNameDescription)
    val displayName: String,
    @GraphQLDescription(imageUrlDescription)
    val imageUrl: String,
)

const val idDescription = "Auto-generated"

// TODO: Need implementing - Max char
const val emailDescription =
    "Email format required eg: `email@test.com`"

// TODO: Need implementing - Max char
const val displayNameDescription =
    "String. Max length 50 characters -> Default \"\""

// TODO: Need implementing - change to imageId
const val imageUrlDescription =
    "Will change to image id in future release. -> Default \"\""

// TODO: Need implementing
const val passwordDescription =
    "Special characters prohibited @£€#¢∞§¶•ªº$%^&*()_+="
const val userDescription = """
UserModel:
- id: String
- email: String
- displayName: String
- imageUrl: String
"""
const val userInputDescription = """
UserInput:
- email: String
- password: String
- displayName: String
- imageUrl: String
"""
const val userProfileDescription = """
UserProfile:
- user: User
- tasks: List<Task>
- comments: List<Comment>
"""
const val userMinimalDescription = """
UserMinimal:
- id: String
- displayName: String
- imageUrl: String
"""

const val deleteUserResultDescription = "placeholder"
