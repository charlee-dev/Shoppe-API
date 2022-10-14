package com.digitaldesigns.shoppe.api.features.review

import com.digitaldesigns.shoppe.api.helpers.SchemaTest
import com.digitaldesigns.shoppe.api.mock.review1
import org.amshove.kluent.shouldBeEqualTo
import kotlin.test.Test
import kotlin.test.assertNull

private const val QUERY =
    "query GetReview(\$reviewId: String!) { getReview(reviewId: \$reviewId) { id authorId productId text rating }}"

class GetReviewTests : SchemaTest() {
    @Test
    fun `when provide reviewId then getReview should return review`() {
        test(
            query = QUERY,
            variables = mapOf("reviewId" to review1.id),
            assert = { response ->
                response.data.toString() shouldBeEqualTo "{getReview={id=1, authorId=user1id, productId=1, text=review1, rating=5}}"
                assertNull(response.errors)
            }
        )
    }
}
