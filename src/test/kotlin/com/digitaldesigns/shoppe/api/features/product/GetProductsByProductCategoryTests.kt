package com.digitaldesigns.shoppe.api.features.product

import com.digitaldesigns.shoppe.api.helpers.SchemaTest
import com.digitaldesigns.shoppe.api.mock.product1
import org.amshove.kluent.shouldBeEqualTo
import kotlin.test.Test
import kotlin.test.assertNull

private const val QUERY =
    "query GetProductsByProductCategory(\$category: Category!, \$pageInput: PageInput!) { getProductsByProductCategory(category: \$category, pageInput: \$pageInput) { results { id name description price userId colors category } info { count pages prev next }}}"

class GetProductsByProductCategoryTests : SchemaTest() {
    @Test
    fun `when provided category CAKE paged then getProductsByProductCategory page one should return one result`() {
        test(
            query = QUERY,
            variables = mapOf(
                "category" to product1.category,
                "pageInput" to mapOf(
                    "page" to 0,
                    "size" to 10
                )
            ),
            assert = { response ->
                response.data.toString() shouldBeEqualTo "{getProductsByProductCategory={results=[{id=1, name=cake, description=, price=10.0, userId=user1id, colors=[blue], category=CAKE}], info={count=1, pages=1, prev=null, next=1}}}"
                assertNull(response.errors)
            }
        )
    }
}
