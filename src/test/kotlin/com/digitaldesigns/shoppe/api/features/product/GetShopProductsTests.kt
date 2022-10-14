package com.digitaldesigns.shoppe.api.features.product

import com.digitaldesigns.shoppe.api.helpers.SchemaTest
import com.digitaldesigns.shoppe.api.mock.shop1
import org.amshove.kluent.shouldBeEqualTo
import kotlin.test.Test
import kotlin.test.assertNull

private const val QUERY =
    "query GetShopProducts(\$shopId: String!, \$pageInput: PageInput!) { getShopProducts(shopId: \$shopId, pageInput: \$pageInput) { results { id name description price userId shopId colors category } info { count pages prev next }}}"

class GetShopProductsTests : SchemaTest() {
    @Test
    fun `when provided shopId paged then getShopProducts page one should return two results`() {
        test(query = QUERY, variables = mapOf(
            "shopId" to shop1.id, "pageInput" to mapOf(
                "page" to 0,
                "size" to 10,
            )
        ), assert = { response ->
            response.data.toString() shouldBeEqualTo "{getShopProducts={results=[{id=1, name=cake, description=, price=10.0, userId=user1id, shopId=1, colors=[blue], category=CAKE}, {id=2, name=car, description=, price=2000.0, userId=user1id, shopId=1, colors=[blue], category=DEFAULT}, {id=3, name=car, description=, price=30.0, userId=user2id, shopId=1, colors=[red, blue], category=DEFAULT}, {id=4, name=red canvas, description=, price=30.0, userId=user2id, shopId=1, colors=[red], category=ART}], info={count=4, pages=1, prev=null, next=1}}}"
            assertNull(response.errors)
        })
    }

    @Test
    fun `when provided shopId but no user with that id exists then getShopProducts should return empty results`() {
        test(query = QUERY, variables = mapOf(
            "shopId" to "shopId10", "pageInput" to mapOf(
                "page" to 0,
                "size" to 10,
            )
        ), assert = { response ->
            response.data.toString() shouldBeEqualTo "{getShopProducts={results=[], info={count=0, pages=0, prev=null, next=null}}}"
            assertNull(response.errors)
        })
    }

    @Test
    fun `when provided shopId paged size one then getShopProducts page one should return one result`() {
        test(query = QUERY, variables = mapOf(
            "shopId" to shop1.id, "pageInput" to mapOf(
                "page" to 0,
                "size" to 1,
            )
        ), assert = { response ->
            response.data.toString() shouldBeEqualTo "{getShopProducts={results=[{id=1, name=cake, description=, price=10.0, userId=user1id, shopId=1, colors=[blue], category=CAKE}], info={count=4, pages=4, prev=null, next=1}}}"
            assertNull(response.errors)
        })
    }

    @Test
    fun `when provided shopId paged size one then getShopProducts page two should return one result`() {
        test(query = QUERY, variables = mapOf(
            "shopId" to shop1.id, "pageInput" to mapOf(
                "page" to 1,
                "size" to 1,
            )
        ), assert = { response ->
            response.data.toString() shouldBeEqualTo "{getShopProducts={results=[{id=2, name=car, description=, price=2000.0, userId=user1id, shopId=1, colors=[blue], category=DEFAULT}], info={count=4, pages=4, prev=0, next=2}}}"
            assertNull(response.errors)
        })
    }
}