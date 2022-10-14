package com.digitaldesigns.shoppe.api.features.review

import com.digitaldesigns.shoppe.api.helpers.SchemaTest
import com.digitaldesigns.shoppe.api.mock.user1
import org.amshove.kluent.shouldBeEqualTo
import kotlin.test.Test
import kotlin.test.assertNull

private const val QUERY =
    "query GetUserReviews(\$userId: String!, \$pageInput: PageInput!) { getUserReviews(userId: \$userId, pageInput: \$pageInput) { results { id authorId productId text rating } info { count pages prev next }}}"

class GetUserReviewsTests : SchemaTest() {
    @Test
    fun `when provide productId then getUserReviews should return reviews`() {
        test(query = QUERY, variables = mapOf(
            "userId" to user1.id, "pageInput" to mapOf(
                "page" to 0,
                "size" to 10,
            )
        ), assert = { response ->
            response.data.toString() shouldBeEqualTo "{getUserReviews={results=[{id=1, authorId=user1id, productId=1, text=review1, rating=5}, {id=2, authorId=user1id, productId=1, text=review2, rating=3}], info={count=2, pages=1, prev=null, next=1}}}"
            assertNull(response.errors)
        })
    }
}
