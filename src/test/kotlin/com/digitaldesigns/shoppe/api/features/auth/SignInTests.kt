package com.digitaldesigns.shoppe.api.features.auth

import com.digitaldesigns.shoppe.api.domain.util.Constants
import com.digitaldesigns.shoppe.api.helpers.SchemaTest
import com.digitaldesigns.shoppe.api.mock.password1
import com.digitaldesigns.shoppe.api.mock.user1
import org.amshove.kluent.shouldBeEqualTo
import org.amshove.kluent.shouldContain
import kotlin.test.Test
import kotlin.test.assertNull

private const val signInMutation =
    "mutation SignIn(\$authInput: AuthInput!) { signIn(authInput: \$authInput) { token user { id displayName imageUrl }}}"

class SignInTests : SchemaTest() {
    @Test
    fun `Sign in with valid credentials should return data with AuthResponse`() = test(
        query = signInMutation,
        variables = mapOf(
            "authInput" to mapOf(
                "email" to user1.email,
                "password" to password1
            )
        ),
        assert = { response ->
            response.data.toString() shouldContain "user={id=user1id, displayName=Adrian, imageUrl=image1}"
            assertNull(response.errors)
        }
    )

    @Test
    fun `Sign in with blank email should return error message`() = test(
        query = signInMutation,
        variables = mapOf(
            "authInput" to mapOf(
                "email" to "",
                "password" to password1
            )
        ),
        assert = { response ->
            response.data shouldBeEqualTo null
            response.errors?.first()?.message?.shouldContain(
                "Exception while fetching data (/signIn) : ${Constants.Messages.EMAIL_BLANK}"
            )
        }
    )

    @Test
    fun `Sign in with blank password should return error message`() = test(
        query = signInMutation,
        variables = mapOf(
            "authInput" to mapOf(
                "email" to user1.email,
                "password" to ""
            )
        ),
        assert = { response ->
            assertNull(response.data)
            response.errors?.first()?.message?.shouldContain(
                "Exception while fetching data (/signIn) : ${Constants.Messages.PASSWORD_BLANK}"
            )
        }
    )

    @Test
    fun `Sign in with invalid email should return error data message`() = test(
        query = signInMutation,
        variables = mapOf(
            "authInput" to mapOf(
                "email" to "invalidEmail",
                "password" to password1
            )
        ),
        assert = { response ->
            assertNull(response.data)
            response.errors?.first()?.message?.shouldContain(
                "Exception while fetching data (/signIn) : ${Constants.Messages.INVALID_CREDENTIALS}"
            )
        }
    )

    @Test
    fun `Sign in with invalid password should return error data message`() = test(
        query = signInMutation,
        variables = mapOf(
            "authInput" to mapOf(
                "email" to user1.email,
                "password" to "invalidPassword"
            )
        ),
        assert = { response ->
            assertNull(response.data)
            response.errors?.first()?.message?.shouldContain(
                "Exception while fetching data (/signIn) : ${Constants.Messages.INVALID_CREDENTIALS}"
            )
        }
    )
}
