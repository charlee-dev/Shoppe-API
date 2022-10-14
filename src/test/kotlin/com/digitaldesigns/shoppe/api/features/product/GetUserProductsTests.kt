package com.digitaldesigns.shoppe.api.features.product

import com.digitaldesigns.shoppe.api.helpers.SchemaTest
import com.digitaldesigns.shoppe.api.mock.user1
import org.amshove.kluent.shouldBeEqualTo
import kotlin.test.Test
import kotlin.test.assertNull

private const val QUERY =
    "query GetUserProducts(\$userId: String!, \$pageInput: PageInput!) { getUserProducts(userId: \$userId, pageInput: \$pageInput) { results { id name description price userId colors category } info { count pages prev next }}}"

class GetUserProductsTests : SchemaTest() {
    @Test
    fun `when provided userId paged then getUserProducts page one should return two results`() {
        test(query = QUERY, variables = mapOf(
            "userId" to user1.id, "pageInput" to mapOf(
                "page" to 0,
                "size" to 10,
            )
        ), assert = { response ->
            response.data.toString() shouldBeEqualTo "{getUserProducts={results=[{id=1, name=cake, description=, price=10.0, userId=user1id, colors=[blue], category=CAKE}, {id=2, name=car, description=, price=2000.0, userId=user1id, colors=[blue], category=DEFAULT}], info={count=2, pages=1, prev=null, next=1}}}"
            assertNull(response.errors)
        })
    }

    @Test
    fun `when provided userId but no user with that id exists then getUserProducts should return empty results`() {
        test(query = QUERY, variables = mapOf(
            "userId" to "userid10", "pageInput" to mapOf(
                "page" to 0,
                "size" to 10,
            )
        ), assert = { response ->
            response.data.toString() shouldBeEqualTo "{getUserProducts={results=[], info={count=0, pages=0, prev=null, next=null}}}"
            assertNull(response.errors)
        })
    }

    @Test
    fun `when provided userId paged size one then getUserProducts page one should return one result`() {
        test(query = QUERY, variables = mapOf(
            "userId" to user1.id, "pageInput" to mapOf(
                "page" to 0,
                "size" to 1,
            )
        ), assert = { response ->
            response.data.toString() shouldBeEqualTo "{getUserProducts={results=[{id=1, name=cake, description=, price=10.0, userId=user1id, colors=[blue], category=CAKE}], info={count=2, pages=2, prev=null, next=1}}}"
            assertNull(response.errors)
        })
    }

    @Test
    fun `when provided userId paged size one then getUserProducts page two should return one result`() {
        test(query = QUERY, variables = mapOf(
            "userId" to user1.id, "pageInput" to mapOf(
                "page" to 1,
                "size" to 1,
            )
        ), assert = { response ->
            response.data.toString() shouldBeEqualTo "{getUserProducts={results=[{id=2, name=car, description=, price=2000.0, userId=user1id, colors=[blue], category=DEFAULT}], info={count=2, pages=2, prev=0, next=2}}}"
            assertNull(response.errors)
        })
    }
}
