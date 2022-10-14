package com.digitaldesigns.shoppe.api.features.shop

import com.digitaldesigns.shoppe.api.helpers.SchemaTest
import org.amshove.kluent.shouldContain
import kotlin.test.Test
import kotlin.test.assertNull

private const val QUERY =
    "mutation AddShop(\$shopBasicInput: ShopInput!) { addShop(shopBasicInput: \$shopBasicInput) { id name description ownerId }}"

class CreateShopsTests : SchemaTest() {
    @Test
    fun `when search for name then addShop should return one result`() = test(
        query = QUERY,
        variables = mapOf(
            "shopBasicInput" to mapOf(
                "name" to "addedShop",
                "description" to "descriptionShop",
                "logo" to "logoShop",
            )
        ), assert = { response ->
            response.data.toString() shouldContain "name=addedShop, description=descriptionShop, ownerId=user1id}}"
            assertNull(response.errors)
        }
    )
}