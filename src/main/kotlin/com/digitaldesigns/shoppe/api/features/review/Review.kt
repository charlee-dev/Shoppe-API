package com.digitaldesigns.shoppe.api.features.review

import com.digitaldesigns.shoppe.api.domain.models.Model
import com.digitaldesigns.shoppe.api.domain.models.Page
import com.digitaldesigns.shoppe.api.domain.models.PagingInfo
import com.digitaldesigns.shoppe.api.domain.util.generateId
import com.expediagroup.graphql.generator.annotations.GraphQLDescription
import io.ktor.util.date.getTimeMillis

@GraphQLDescription(reviewDescription)
data class Review(
    @GraphQLDescription(reviewIdDescription)
    override val id: String = generateId(),
    @GraphQLDescription(userIdDescription)
    val authorId: String,
    @GraphQLDescription(taskIdDescription)
    val productId: String,
    @GraphQLDescription(textDescription)
    val text: String,
    @GraphQLDescription(ratingDescription)
    val rating: Int,
    @GraphQLDescription(dateCreatedDescription)
    val dateCreated: String = getTimeMillis().toString(),
) : Model

@GraphQLDescription(reviewInputDescription)
data class ReviewInput(
    @GraphQLDescription(textDescription)
    val text: String,
    @GraphQLDescription(ratingDescription)
    val rating: Int,
)

@GraphQLDescription(reviewPageDescription)
data class ReviewPage(
    val results: List<Review>,
    val info: PagingInfo,
)

fun Page<Review>.toReviewPage() = ReviewPage(
    results = results,
    info = info
)

const val reviewIdDescription = "Review id"
const val userIdDescription = "UserId of user that created this object"
const val taskIdDescription = "Task parent id"
const val textDescription = "Review content"
const val ratingDescription = "Selected rating in range 1..5"
const val reviewDescription = """
Review:
userId: String
taskId: String
text: String
rating: Int
"""
const val reviewInputDescription = """
ReviewInput:
text: String
rating: Int
"""
const val dateCreatedDescription = "placeholder"
const val reviewPageDescription = "placeholder"
