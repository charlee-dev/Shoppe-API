package com.digitaldesigns.shoppe.api.features.review

import com.digitaldesigns.shoppe.api.helpers.SchemaTest
import com.digitaldesigns.shoppe.api.mock.review1
import org.amshove.kluent.shouldBeEqualTo
import kotlin.test.Test
import kotlin.test.assertNull

private const val QUERY =
    "mutation DeleteReview(\$reviewId: String!) { deleteReview(reviewId: \$reviewId)}"

class DeleteReviewTests : SchemaTest() {
    @Test
    fun `when provide reviewInput then updateReview should return updated review`() {
        test(
            query = QUERY,
            variables = mapOf("reviewId" to review1.id),
            assert = { response ->
                response.data.toString() shouldBeEqualTo "{deleteReview=true}"
                assertNull(response.errors)
            }
        )
    }
}
