package com.digitaldesigns.shoppe.api.features.review

import com.digitaldesigns.shoppe.api.domain.models.PageInput
import com.digitaldesigns.shoppe.api.domain.repository.CrudRepository
import com.digitaldesigns.shoppe.api.domain.util.Constants.DATABASE_NAME
import com.digitaldesigns.shoppe.api.domain.util.Constants.REVIEW_COLLECTION
import com.digitaldesigns.shoppe.api.domain.util.doSafely
import com.digitaldesigns.shoppe.api.domain.util.inPages
import com.mongodb.client.MongoClient
import com.mongodb.client.MongoCollection
import org.litote.kmongo.eq
import org.litote.kmongo.getCollection

class ReviewRepository(client: MongoClient) : CrudRepository<Review> {
    override lateinit var col: MongoCollection<Review>

    init {
        val database = client.getDatabase(DATABASE_NAME)
        col = database.getCollection<Review>(REVIEW_COLLECTION)
    }

    fun getReviewsByProductIdPaged(productId: String, pageInput: PageInput): ReviewPage = doSafely {
        val filter = Review::productId eq productId
        col.inPages(filter, pageInput).toReviewPage().apply {
            results.sortedBy(Review::rating)
        }
    }

    fun getReviewsByProductId(productId: String): List<Review> = doSafely {
        col.find(Review::productId eq productId).sortedBy(Review::rating)
    }

    fun getReviewsByUserIdPaged(userId: String, pageInput: PageInput): ReviewPage = doSafely {
        val filter = Review::authorId eq userId
        col.inPages(filter, pageInput).toReviewPage().apply {
            results.sortedBy(Review::rating)
        }
    }

    fun getAllByShopId(shopId: String, pageInput: PageInput): ReviewPage = doSafely {
        val filter = Review::productId eq shopId
        col.inPages(filter, pageInput).toReviewPage().apply {
            results.sortedBy(Review::rating)
        }
    }

    fun deleteAllReviewsOfProduct(productId: String): List<String> {
        val filter = Review::productId eq productId
        val reviewsIds = col.find(filter).toList().map(Review::id)
        reviewsIds.forEach { delete(it) }
        return reviewsIds
    }
}
