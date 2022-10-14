package com.digitaldesigns.shoppe.api.features.review

import com.digitaldesigns.shoppe.api.helpers.SchemaTest
import com.digitaldesigns.shoppe.api.mock.review1
import org.amshove.kluent.shouldBeEqualTo
import kotlin.test.Test
import kotlin.test.assertNull

private const val QUERY =
    "mutation updateReview(\$reviewId: String!, \$reviewInput: ReviewInput!) { updateReview(reviewId: \$reviewId, reviewInput: \$reviewInput) { id authorId productId text rating }}"

class UpdateReviewTests : SchemaTest() {
    @Test
    fun `when provide reviewInput then updateReview should return updated review`() {
        test(
            query = QUERY,
            variables = mapOf(
                "reviewId" to review1.id,
                "reviewInput" to mapOf(
                    "text" to "updated review",
                    "rating" to 2
                )
            ),
            assert = { response ->
                response.data.toString() shouldBeEqualTo "{updateReview={id=1, authorId=user1id, productId=1, text=updated review, rating=2}}"
                assertNull(response.errors)
            }
        )
    }
}
