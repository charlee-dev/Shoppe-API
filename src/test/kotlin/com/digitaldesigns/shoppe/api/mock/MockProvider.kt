package com.digitaldesigns.shoppe.api.mock

import com.digitaldesigns.shoppe.api.features.product.ProductRepository
import com.digitaldesigns.shoppe.api.features.product.model.Product
import com.digitaldesigns.shoppe.api.features.review.Review
import com.digitaldesigns.shoppe.api.features.review.ReviewRepository
import com.digitaldesigns.shoppe.api.features.shop.ShopRepository
import com.digitaldesigns.shoppe.api.features.user.UserModel
import com.digitaldesigns.shoppe.api.features.user.UserRepository
import org.litote.kmongo.KMongoBaseTest

object MockProvider {
    val userRepository = UserRepo.instance
    val productRepository = ProductRepo.instance
    val reviewRepository = ReviewRepo.instance
    val shopRepository = ShopRepo.instance

    private object UserRepo : KMongoBaseTest<UserModel>() {
        val instance = UserRepository(mongoClient)
    }

    private object ProductRepo : KMongoBaseTest<Product>() {
        val instance = ProductRepository(mongoClient)
    }

    private object ReviewRepo : KMongoBaseTest<Review>() {
        val instance = ReviewRepository(mongoClient)
    }

    private object ShopRepo : KMongoBaseTest<Review>() {
        val instance = ShopRepository(mongoClient)
    }
}
