package com.digitaldesigns.shoppe.api.features.review

import com.digitaldesigns.shoppe.api.domain.models.Model
import com.digitaldesigns.shoppe.api.domain.models.Page
import com.digitaldesigns.shoppe.api.domain.models.PagingInfo
import com.digitaldesigns.shoppe.api.domain.util.generateId
import com.digitaldesigns.shoppe.api.graphql.GraphQLDesc
import com.expediagroup.graphql.generator.annotations.GraphQLDescription
import io.ktor.util.date.getTimeMillis

@GraphQLDescription(GraphQLDesc.Review.model)
data class Review(
    @GraphQLDescription(GraphQLDesc.Review.id) override val id: String = generateId(),
    @GraphQLDescription(GraphQLDesc.Review.authorId) val authorId: String,
    @GraphQLDescription(GraphQLDesc.Review.productId) val productId: String,
    @GraphQLDescription(GraphQLDesc.Review.text) val text: String,
    @GraphQLDescription(GraphQLDesc.Review.rating) val rating: Int,
    @GraphQLDescription(GraphQLDesc.Review.dateCreated) val dateCreated: String = getTimeMillis().toString(),
    @GraphQLDescription(GraphQLDesc.Review.verified) var verified: Boolean,
) : Model

@GraphQLDescription(GraphQLDesc.Review.Input.model)
data class ReviewInput(
    @GraphQLDescription(GraphQLDesc.Review.Input.text) val text: String,
    @GraphQLDescription(GraphQLDesc.Review.Input.rating) val rating: Int,
)

@GraphQLDescription(GraphQLDesc.Review.Page.model)
data class ReviewPage(
    @GraphQLDescription(GraphQLDesc.Review.Page.results) val results: List<Review>,
    @GraphQLDescription(GraphQLDesc.Review.Page.info) val info: PagingInfo,
)

fun Page<Review>.toReviewPage() = ReviewPage(
    results = results,
    info = info
)
