package com.digitaldesigns.shoppe.api.features.product

import com.digitaldesigns.shoppe.api.features.product.model.classes.ProductCategory
import com.digitaldesigns.shoppe.api.helpers.SchemaTest
import com.digitaldesigns.shoppe.api.mock.shop1
import org.amshove.kluent.shouldContain
import kotlin.test.Test
import kotlin.test.assertNull

private const val QUERY =
    "mutation AddProduct(\$shopId: String!, \$productCreateInput: ProductCreateInput!) { createProduct(shopId: \$shopId, productCreateInput: \$productCreateInput) { id name desc price userId categories { name }}}"

class CreateProductTests : SchemaTest() {
    @Test
    fun `when provided productBasicInput then addProduct should should return created product`() {
        test(
            query = QUERY,
            variables = mapOf(
                "shopId" to shop1.id,
                "productCreateInput" to mapOf(
                    "name" to "new product",
                    "remainingStock" to 10,
                    "categories" to listOf<ProductCategory>(), // FixMe:
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
