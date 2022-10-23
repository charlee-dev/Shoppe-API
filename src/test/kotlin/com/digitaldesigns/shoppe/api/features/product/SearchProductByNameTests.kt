package com.digitaldesigns.shoppe.api.features.product

import com.digitaldesigns.shoppe.api.helpers.SchemaTest
import com.digitaldesigns.shoppe.api.mock.product1
import com.digitaldesigns.shoppe.api.mock.product2
import com.digitaldesigns.shoppe.api.mock.product3
import org.amshove.kluent.shouldBeEqualTo
import kotlin.test.Test
import kotlin.test.assertNull

private const val QUERY =
    "query SearchProductByName(\$query: String!, \$pageInput: PageInput!) { searchProductByName(query: \$query, pageInput: \$pageInput) { results { id name description price userId colors category } info { count pages prev next }}}"

class SearchProductByNameTests : SchemaTest() {
    @Test
    fun `when search for cake then searchProductByName should return one result`() {
        test(
            query = QUERY,
            variables = mapOf(
                "query" to product1.name,
                "pageInput" to mapOf(
                    "page" to 0,
                    "size" to 10
                )
            ),
            assert = { response ->
                response.data.toString() shouldBeEqualTo "{searchProductByName={results=[{id=1, name=cake, description=, price=10.0, userId=user1id, colors=[blue], category=CAKE}], info={count=1, pages=1, prev=null, next=1}}}"
                assertNull(response.errors)
            }
        )
    }

    @Test
    fun `when search for 1 then searchProductByName should return no results`() {
        test(
            query = QUERY,
            variables = mapOf(
                "query" to "1",
                "pageInput" to mapOf(
                    "page" to 0,
                    "size" to 10
                )
            ),
            assert = { response ->
                response.data.toString() shouldBeEqualTo "{searchProductByName={results=[], info={count=0, pages=0, prev=null, next=null}}}"
                assertNull(response.errors)
            }
        )
    }

    @Test
    fun `when search for name car then searchProductByName should return two results`() {
        test(
            query = QUERY,
            variables = mapOf(
                "query" to product2.name,
                "pageInput" to mapOf(
                    "page" to 0,
                    "size" to 10
                )
            ),
            assert = { response ->
                response.data.toString() shouldBeEqualTo "{searchProductByName={results=[{id=2, name=car, description=, price=2000.0, userId=user1id, colors=[blue], category=DEFAULT}, {id=3, name=car, description=, price=30.0, userId=user2id, colors=[red, blue], category=DEFAULT}], info={count=2, pages=1, prev=null, next=1}}}"
                assertNull(response.errors)
            }
        )
    }

    @Test
    fun `when search for color red then searchProductByName should return two results`() {
        test(
            query = QUERY,
            variables = mapOf(
                "query" to product3,  // Fixme: color
                "pageInput" to mapOf(
                    "page" to 0,
                    "size" to 10
                )
            ),
            assert = { response ->
                response.data.toString() shouldBeEqualTo "{searchProductByName={results=[{id=3, name=car, description=, price=30.0, userId=user2id, colors=[red, blue], category=DEFAULT}, {id=4, name=red canvas, description=, price=30.0, userId=user2id, colors=[red], category=ART}], info={count=2, pages=1, prev=null, next=1}}}"
                assertNull(response.errors)
            }
        )
    }

    @Test
    fun `when search for color red with paging then searchProductByName get page one should return one result`() {
        test(
            query = QUERY,
            variables = mapOf(
                "query" to product3,  // Fixme: color
                "pageInput" to mapOf(
                    "page" to 0,
                    "size" to 1
                )
            ),
            assert = { response ->
                response.data.toString() shouldBeEqualTo "{searchProductByName={results=[{id=3, name=car, description=, price=30.0, userId=user2id, colors=[red, blue], category=DEFAULT}], info={count=2, pages=2, prev=null, next=1}}}"
                assertNull(response.errors)
            }
        )
    }

    @Test
    fun `when search for color red with paging then searchProductByName get page two should return one result`() {
        test(
            query = QUERY,
            variables = mapOf(
                "query" to product3, // FIXME: color
                "pageInput" to mapOf(
                    "page" to 1,
                    "size" to 1
                )
            ),
            assert = { response ->
                response.data.toString() shouldBeEqualTo "{searchProductByName={results=[{id=4, name=red canvas, description=, price=30.0, userId=user2id, colors=[red], category=ART}], info={count=2, pages=2, prev=0, next=2}}}"
                assertNull(response.errors)
            }
        )
    }
}
