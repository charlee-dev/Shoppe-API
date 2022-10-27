package com.digitaldesigns.shoppe.api.features.product

import com.digitaldesigns.shoppe.api.features.product.model.shared.ProductCategory
import com.digitaldesigns.shoppe.api.helpers.SchemaTest
import com.digitaldesigns.shoppe.api.mock.product1
import com.digitaldesigns.shoppe.api.mock.shop1
import com.digitaldesigns.shoppe.api.mock.user1
import org.amshove.kluent.shouldBeEqualTo
import kotlin.test.Test
import kotlin.test.assertNull

private const val QUERY =
    "mutation UpdateProduct(\$productId: String!, \$shopId: String!, \$productUpdateInput: ProductUpdateInput!) { updateProduct(productId: \$productId, shopId: \$shopId, productUpdateInput: \$productUpdateInput) { id name description price userId shopId colors category }}"

class UpdateProductTests : SchemaTest() {
    @Test
    fun `when provided productUpdateInput then updateProduct should should return updated product`() {
        test(
            query = QUERY,
            variables = mapOf(
                "productId" to product1.id,
                "shopId" to shop1.id,
                "productUpdateInput" to mapOf(
                    "name" to "updated product",
                    "description" to "updated description",
                    "images" to listOf("updated image"),
                    "category" to ProductCategory(name = "default", createdBy = user1.id),  // Fixme; category
                    "price" to 20.0
                )
            ),
            assert = { response ->
                response.data.toString() shouldBeEqualTo "{updateProduct={id=1, name=updated product, description=updated description, price=20.0, userId=user1id, shopId=1, colors=[], category=HANDMADE}}"
                assertNull(response.errors)
            }
        )
    }
}
