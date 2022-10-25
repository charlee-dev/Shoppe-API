package com.digitaldesigns.shoppe.api.features.review

import com.digitaldesigns.shoppe.api.domain.models.PageInput
import com.digitaldesigns.shoppe.api.domain.util.withCurrentUser
import com.digitaldesigns.shoppe.api.graphql.GraphQLDesc
import com.expediagroup.graphql.generator.annotations.GraphQLDescription
import com.expediagroup.graphql.server.operations.Mutation
import com.expediagroup.graphql.server.operations.Query
import graphql.schema.DataFetchingEnvironment
import org.koin.java.KoinJavaComponent.inject

class ReviewSchema {
    class Queries : Query {
        private val reviewService: ReviewService by inject(ReviewService::class.java)

        @GraphQLDescription("getReview")
        @Suppress("unused")
        fun getReview(
            dfe: DataFetchingEnvironment,
            @GraphQLDescription(GraphQLDesc.Review.id)
            reviewId: String,
        ): Review {
            return dfe.withCurrentUser { userId ->
                reviewService.getReview(userId, reviewId)
            }
        }

        @GraphQLDescription("getProductReviews")
        @Suppress("unused")
        fun getProductReviews(
            @GraphQLDescription(GraphQLDesc.Review.productId)
            productId: String,
            @GraphQLDescription(GraphQLDesc.PageInput.model)
            pageInput: PageInput,
        ): ReviewPage {
            return reviewService.getProductReviews(productId, pageInput)
        }

        @GraphQLDescription("getUserReviews")
        @Suppress("unused")
        fun getUserReviews(
            @GraphQLDescription(GraphQLDesc.User.model)
            userId: String,
            @GraphQLDescription(GraphQLDesc.PageInput.model)
            pageInput: PageInput,
        ): ReviewPage {
            return reviewService.getUserReviews(userId, pageInput)
        }

        @GraphQLDescription("getShopReviews")
        @Suppress("unused")
        fun getShopReviews(
            @GraphQLDescription(GraphQLDesc.Shop.id)
            shopId: String,
            @GraphQLDescription(GraphQLDesc.PageInput.model)
            pageInput: PageInput,
        ): ReviewPage {
            return reviewService.getShopReviews(shopId, pageInput)
        }
    }

    class Mutations : Mutation {
        private val reviewService: ReviewService by inject(ReviewService::class.java)

        @GraphQLDescription("createReview")
        @Suppress("unused")
        fun createReview(
            dfe: DataFetchingEnvironment,
            @GraphQLDescription(GraphQLDesc.Product.id)
            productId: String,
            @GraphQLDescription(GraphQLDesc.ReviewInput.model)
            reviewInput: ReviewInput,
        ): Review {
            return dfe.withCurrentUser { userId ->
                reviewService.createReview(userId, productId, reviewInput)
            }
        }

        @GraphQLDescription("updateReview")
        @Suppress("unused")
        fun updateReview(
            dfe: DataFetchingEnvironment,
            @GraphQLDescription(GraphQLDesc.Review.id)
            reviewId: String,
            @GraphQLDescription(GraphQLDesc.ReviewInput.model)
            reviewInput: ReviewInput,
        ): Review {
            return dfe.withCurrentUser { userId ->
                reviewService.updateReview(userId, reviewId, reviewInput)
            }
        }

        @GraphQLDescription("deleteReview")
        @Suppress("unused")
        fun deleteReview(
            dfe: DataFetchingEnvironment,
            @GraphQLDescription(GraphQLDesc.Review.id)
            reviewId: String,
        ): Boolean {
            return dfe.withCurrentUser { userId ->
                reviewService.deleteReview(userId, reviewId)
            }
        }
    }
}
