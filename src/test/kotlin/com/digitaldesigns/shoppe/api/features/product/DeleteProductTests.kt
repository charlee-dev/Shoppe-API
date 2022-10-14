package com.digitaldesigns.shoppe.api.features.product

import com.digitaldesigns.shoppe.api.helpers.SchemaTest
import com.digitaldesigns.shoppe.api.mock.product1
import org.amshove.kluent.shouldBeEqualTo
import kotlin.test.Test
import kotlin.test.assertNull

private const val QUERY =
    "mutation DeleteProduct(\$productId: String!) { deleteProduct(productId: \$productId) }"

class DeleteProductTests : SchemaTest() {
    @Test
    fun `when provided productId and product exist then deleteProduct should return true`() {
        test(
            query = QUERY,
            variables = mapOf("productId" to product1.id),
            assert = { response ->
                response.data.toString() shouldBeEqualTo "{deleteProduct=true}"
                assertNull(response.errors)
            }
        )
    }
}
