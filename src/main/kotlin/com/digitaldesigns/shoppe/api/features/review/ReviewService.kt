package com.digitaldesigns.shoppe.api.features.review

import com.digitaldesigns.shoppe.api.domain.models.PageInput
import com.digitaldesigns.shoppe.api.domain.util.checkPermissions
import com.digitaldesigns.shoppe.api.features.order.OrderRepository
import com.digitaldesigns.shoppe.api.features.order.model.Order
import com.digitaldesigns.shoppe.api.features.order.model.OrderLineItem
import com.digitaldesigns.shoppe.api.features.product.ProductRepository

class ReviewService(
    private val reviewRepository: ReviewRepository,
    private val productRepository: ProductRepository,
    private val orderRepository: OrderRepository,
) {
    fun getReview(userId: String, reviewId: String): Review {
        val review = reviewRepository.getById(reviewId)
        return checkPermissions(userId, review.authorId) {
            reviewRepository.getById(reviewId)
        }
    }

    fun createReview(userId: String, productId: String, reviewInput: ReviewInput): Review {
        val product = productRepository.getById(productId)
        return checkPermissions(userId, product.userId) {
            val review = Review(
                authorId = userId,
                productId = productId,
                text = reviewInput.text,
                rating = reviewInput.rating,
                verified = isVerified(userId, productId)
            )
            reviewRepository.add(review)
        }
    }

    private fun isVerified(userId: String, productId: String): Boolean {
        val userOrderedProducts = orderRepository.getOrdersByUserId(userId)
            .flatMap(Order::lineItems)
            .map(OrderLineItem::productId) // TODO: This can be done by mongo
        return productId in userOrderedProducts
    }

    fun updateReview(userId: String, reviewId: String, reviewInput: ReviewInput): Review {
        val review = reviewRepository.getById(reviewId)
        return checkPermissions(userId, review.authorId) {
            val updates = Review(
                id = reviewId,
                productId = review.productId,
                authorId = userId,
                text = reviewInput.text,
                rating = reviewInput.rating,
                verified = isVerified(userId, review.productId)
            )
            reviewRepository.update(updates)
        }
    }

    fun deleteReview(userId: String, reviewId: String): Boolean {
        val review = reviewRepository.getById(reviewId)
        return checkPermissions(userId, review.authorId) {
            reviewRepository.delete(reviewId)
        }
    }

    fun getProductReviews(productId: String, pageInput: PageInput): ReviewPage {
        return reviewRepository.getReviewsByProductIdPaged(productId, pageInput)
    }

    fun getUserReviews(userId: String, pageInput: PageInput): ReviewPage {
        return reviewRepository.getReviewsByUserIdPaged(userId, pageInput)
    }

    fun getShopReviews(shopId: String, pageInput: PageInput): ReviewPage {
        return reviewRepository.getAllByShopId(shopId, pageInput)
    }
}
