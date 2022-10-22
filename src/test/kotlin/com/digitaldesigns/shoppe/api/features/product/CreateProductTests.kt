package com.digitaldesigns.shoppe.api.features.product

import com.digitaldesigns.shoppe.api.features.product.model.Category
import com.digitaldesigns.shoppe.api.helpers.SchemaTest
import com.digitaldesigns.shoppe.api.mock.shop1
import org.amshove.kluent.shouldContain
import kotlin.test.Test
import kotlin.test.assertNull

private const val QUERY =
    "mutation AddProduct(\$shopId: String!, \$productBasicInput: ProductBasicInput!) { createProduct(shopId: \$shopId, productBasicInput: \$productBasicInput) { id name description price userId colors category }}"

class CreateProductTests : SchemaTest() {
    @Test
    fun `when provided productBasicInput then addProduct should should return created product`() {
        test(
            query = QUERY,
            variables = mapOf(
                "shopId" to shop1.id,
                "productBasicInput" to mapOf(
                    "name" to "new product",
                    "description" to "new description",
                    "images" to listOf("new image"),
                    "category" to Category.HANDMADE,
                    "price" to 10.0
                )
            ),
            assert = { response ->
                response.data.toString() shouldContain "name=new product, description=new description, price=10.0, userId=user1id, colors=[], category=HANDMADE}}"
                assertNull(response.errors)
            }
        )
    }
}
