package com.digitaldesigns.shoppe.api.features.review

import com.digitaldesigns.shoppe.api.domain.models.PageInput
import com.digitaldesigns.shoppe.api.domain.util.withCurrentUser
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
            reviewId: String,
        ): Review {
            return dfe.withCurrentUser { userId ->
                reviewService.getReview(userId, reviewId)
            }
        }

        @GraphQLDescription("getProductReviews")
        @Suppress("unused")
        fun getProductReviews(
            productId: String,
            pageInput: PageInput,
        ): ReviewPage {
            return reviewService.getProductReviews(productId, pageInput)
        }

        @GraphQLDescription("getUserReviews")
        @Suppress("unused")
        fun getUserReviews(
            userId: String,
            pageInput: PageInput,
        ): ReviewPage {
            return reviewService.getUserReviews(userId, pageInput)
        }

        @GraphQLDescription("getShopReviews")
        @Suppress("unused")
        fun getShopReviews(
            shopId: String,
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
            productId: String,
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
            reviewId: String,
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
            reviewId: String,
        ): Boolean {
            return dfe.withCurrentUser { userId ->
                reviewService.deleteReview(userId, reviewId)
            }
        }
    }
}
