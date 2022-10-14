package com.digitaldesigns.shoppe.api.features.user

import com.digitaldesigns.shoppe.api.helpers.SchemaTest
import org.amshove.kluent.shouldBeEqualTo
import kotlin.test.Test
import kotlin.test.assertNull

class DeleteUserTests : SchemaTest() {
    private val deleteMutation =
        "mutation DeleteUser { deleteUser }"

    @Test
    fun `when user exists then deleteMutation should delete user with user products and product reviews`() =
        test(
            query = deleteMutation,
            assert = { response ->
                response.data.toString() shouldBeEqualTo "{deleteUser=true}"
                assertNull(response.errors)
            }
        )
}
