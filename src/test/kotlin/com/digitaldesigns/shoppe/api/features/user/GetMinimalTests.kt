package com.digitaldesigns.shoppe.api.features.user

import com.digitaldesigns.shoppe.api.helpers.SchemaTest
import org.amshove.kluent.shouldBeEqualTo
import kotlin.test.Test
import kotlin.test.assertNull

class GetMinimalTests : SchemaTest() {
    private val getUserMinimalMutation =
        "query GetUserMinimal { getUserMinimal { displayName imageUrl }}"

    @Test
    fun `Query getUserMinimalMutation should return UserMinimal`() = test(
        query = getUserMinimalMutation,
        assert = { response ->
            response.data.toString() shouldBeEqualTo "{getUserMinimal={displayName=Adrian, imageUrl=image1}}"
            assertNull(response.errors)
        }
    )
}
