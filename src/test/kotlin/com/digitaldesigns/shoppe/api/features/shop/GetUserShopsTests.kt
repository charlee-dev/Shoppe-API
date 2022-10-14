package com.digitaldesigns.shoppe.api.features.shop

import com.digitaldesigns.shoppe.api.helpers.SchemaTest
import com.digitaldesigns.shoppe.api.mock.user1
import org.amshove.kluent.shouldBeEqualTo
import kotlin.test.Test
import kotlin.test.assertNull

private const val QUERY =
    "query GetUserShops(\$userId: String!, \$pageInput: PageInput!) { getUserShops(userId: \$userId, pageInput: \$pageInput) { results { id name description ownerId } info { count pages prev next }}}"

class GetUserShopsTests : SchemaTest() {
    @Test
    fun `when search for name then searchShopByName should return one result`() = test(
        query = QUERY,
        variables = mapOf(
            "userId" to user1.id,
            "pageInput" to mapOf(
                "page" to 0,
                "size" to 10,
            )
        ),
        assert = { response ->
            response.data.toString() shouldBeEqualTo "{getUserShops={results=[{id=1, name=cakeShop, description=descShop, ownerId=user1id}, {id=2, name=carShop, description=descShop, ownerId=user1id}], info={count=2, pages=1, prev=null, next=1}}}"
            assertNull(response.errors)
        }
    )
}