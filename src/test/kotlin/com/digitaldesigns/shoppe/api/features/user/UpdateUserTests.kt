package com.digitaldesigns.shoppe.api.features.user

import com.digitaldesigns.shoppe.api.domain.util.Constants
import com.digitaldesigns.shoppe.api.helpers.SchemaTest
import com.digitaldesigns.shoppe.api.mock.password2
import com.digitaldesigns.shoppe.api.mock.user2
import org.amshove.kluent.shouldBeEqualTo
import kotlin.test.Test
import kotlin.test.assertNull

class UpdateUserTests : SchemaTest() {
    private val updateUserMutation =
        "mutation UpdateUser(\$userInput: UserInput!) { updateUser(userInput: \$userInput) { id email displayName imageUrl }}"

    private fun userInputVariables(
        displayName: String = user2.displayName,
        email: String = user2.email,
        password: String = password2,
        imageUrl: String = user2.imageUrl,
    ): Map<String, Any?> = mapOf(
        "userInput" to mapOf(
            "email" to email,
            "password" to password,
            "displayName" to displayName,
            "imageUrl" to imageUrl
        )
    )

    @Test
    fun `when updating to unique email then updateUserMutation should return updated user`() =
        test(
            query = updateUserMutation,
            variables = userInputVariables(email = "testEmail4"),
            assert = { response ->
                response.data.toString() shouldBeEqualTo "{updateUser={id=user1id, email=testEmail4, displayName=Natalia, imageUrl=image2}}"
                assertNull(response.errors)
            }
        )

    @Test
    fun `when updating to email that already exists then updateUserMutation should return error and no data`() =
        test(
            query = updateUserMutation,
            variables = userInputVariables(),
            assert = { response ->
                response.errors?.first()?.message.toString() shouldBeEqualTo "Exception while fetching data (/updateUser) : ${Constants.Messages.EMAIL_IN_USE}"
                assertNull(response.data)
            }
        )

    @Test
    fun `updateUserMutation tries update to empty email return error and no data`() = test(
        query = updateUserMutation,
        variables = userInputVariables(email = ""),
        assert = { response ->
            response.errors?.first()?.message.toString() shouldBeEqualTo "Exception while fetching data (/updateUser) : ${Constants.Messages.EMAIL_BLANK}"
            assertNull(response.data)
        }
    )
}
