package com.digitaldesigns.shoppe.api.features.review

import com.digitaldesigns.shoppe.api.helpers.SchemaTest
import com.digitaldesigns.shoppe.api.mock.product1
import org.amshove.kluent.shouldContain
import kotlin.test.Test
import kotlin.test.assertNull

private const val QUERY =
    "mutation CreateReview(\$productId: String!, \$reviewInput: ReviewInput!) { createReview(productId: \$productId, reviewInput: \$reviewInput) { id authorId productId text rating }}"

class CreateReviewTests : SchemaTest() {
    @Test
    fun `when provide reviewInput then createReview should return review`() {
        test(
            query = QUERY,
            variables = mapOf(
                "productId" to product1.id,
                "reviewInput" to mapOf(
                    "text" to "new review",
                    "rating" to 4
                )
            ),
            assert = { response ->
                response.data.toString() shouldContain ", authorId=user1id, productId=1, text=new review, rating=4}}"
                assertNull(response.errors)
            }
        )
    }
}
