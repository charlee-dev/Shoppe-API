package com.digitaldesigns.shoppe.api.features.shop

import com.digitaldesigns.shoppe.api.helpers.SchemaTest
import com.digitaldesigns.shoppe.api.mock.shop1
import org.amshove.kluent.shouldContain
import kotlin.test.Ignore
import kotlin.test.Test
import kotlin.test.assertNull

private const val QUERY =
    "mutation UpdateShop(\$shopId: String!, \$shopUpdateInput: ShopInput!) { updateShop(shopId: \$shopId, shopUpdateInput: \$shopUpdateInput) { id name description ownerId }}"

class UpdateShopTests : SchemaTest() {
    @Ignore
    @Test
    fun `when updateShop should return one result`() = test(
        query = QUERY,
        variables = mapOf(
            "shopId" to shop1.id,
            "shopUpdateInput" to mapOf(
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