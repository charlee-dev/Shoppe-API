package com.digitaldesigns.shoppe.api.features.shop

import com.digitaldesigns.shoppe.api.helpers.SchemaTest
import com.digitaldesigns.shoppe.api.mock.shop1
import org.amshove.kluent.shouldBeEqualTo
import kotlin.test.Test
import kotlin.test.assertNull

private const val QUERY =
    "query SearchShopByName(\$query: String!, \$pageInput: PageInput!) { searchShopByName(query: \$query, pageInput: \$pageInput) { results { id name description ownerId } info { count pages prev next }}}"

class SearchShopByNameTests : SchemaTest() {
    @Test
    fun `when search for name then searchShopByName should return one result`() = test(
        query = QUERY,
        variables = mapOf(
            "query" to shop1.name,
            "pageInput" to mapOf(
                "page" to 0,
                "size" to 10,
            )
        ),
        assert = { response ->
            response.data.toString() shouldBeEqualTo "{searchShopByName={results=[{id=1, name=cakeShop, description=descShop, ownerId=user1id}], info={count=1, pages=1, prev=null, next=1}}}"
            assertNull(response.errors)
        }
    )
}