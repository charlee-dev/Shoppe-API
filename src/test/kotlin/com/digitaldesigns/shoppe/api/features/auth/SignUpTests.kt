package com.digitaldesigns.shoppe.api.features.auth

import com.digitaldesigns.shoppe.api.domain.util.Constants
import com.digitaldesigns.shoppe.api.helpers.SchemaTest
import com.digitaldesigns.shoppe.api.mock.password1
import com.digitaldesigns.shoppe.api.mock.user1
import org.amshove.kluent.shouldContain
import kotlin.test.Test
import kotlin.test.assertNull

private const val QUERY =
    "mutation signUp(\$authInput: AuthInput!) { signUp(authInput: \$authInput) { token user { id displayName imageUrl }}}"

class SignUpTests : SchemaTest() {
    @Test
    fun `Sign up new user should return data with AuthResponse`() = test(
        users = emptyList(),
        query = QUERY,
        variables = mapOf(
            "authInput" to mapOf(
                "email" to user1.email,
                "password" to password1
            )
        ),
        assert = { response ->
            response.data.toString() shouldContain "{signUp={token=" shouldContain "user={id=" shouldContain ", displayName=, imageUrl=}}}"
            assertNull(response.errors)
        }
    )

    @Test
    fun `Sign up but User already exists, returns email in use message`() = test(
        query = QUERY,
        variables = mapOf(
            "authInput" to mapOf(
                "email" to user1.email,
                "password" to password1
            )
        ),
        assert = { response ->
            assertNull(response.data)
            response.errors?.first()?.message?.shouldContain(
                "Exception while fetching data (/signUp) : ${Constants.Messages.EMAIL_IN_USE}"
            )
        }
    )

    @Test
    fun `Sign up with blank email should return error message`() = test(
        query = QUERY,
        variables = mapOf(
            "authInput" to mapOf(
                "email" to "",
                "password" to password1
            )
        ),
        assert = { response ->
            assertNull(response.data)
            response.errors?.first()?.message?.shouldContain(
                "Exception while fetching data (/signUp) : ${Constants.Messages.EMAIL_BLANK}"
            )
        }
    )

    @Test
    fun `Sign up with blank password should return error message`() = test(
        query = QUERY,
        variables = mapOf(
            "authInput" to mapOf(
                "email" to user1.email,
                "password" to ""
            )
        ),
        assert = { response ->
            assertNull(response.data)
            response.errors?.first()?.message?.shouldContain(
                "Exception while fetching data (/signUp) : ${Constants.Messages.PASSWORD_BLANK}"
            )
        }
    )
}
