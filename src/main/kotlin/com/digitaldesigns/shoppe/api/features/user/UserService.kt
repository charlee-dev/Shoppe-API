package com.digitaldesigns.shoppe.api.features.user

import com.digitaldesigns.shoppe.api.features.product.ProductRepository
import com.digitaldesigns.shoppe.api.features.review.ReviewRepository
import com.digitaldesigns.shoppe.api.features.shop.ShopRepository

class UserService(
    private val userRepository: UserRepository,
    private val shopRepository: ShopRepository,
    private val productRepository: ProductRepository,
    private val reviewRepository: ReviewRepository,
) {
    fun getUserProfile(userId: String): UserProfile {
        val user = userRepository.getById(userId)
        return UserProfile(user)
    }

    fun updateUser(userId: String, userUpdateInput: UserUpdateInput): UserModel {
        userUpdateInput.validate()
        userRepository throwIfUserWithThatEmailExists userUpdateInput.email
        val user = userUpdateInput.toUser(userId)
        return userRepository.update(user)
    }

    fun getUserMinimal(userId: String): UserMinimal {
        return userRepository.getMinimalUser(userId)
    }

    fun deleteUser(userId: String): Boolean {
        deleteLinkedShops(userId)
        return userRepository.delete(userId)
    }

    private fun deleteLinkedShops(userId: String) {
        shopRepository.deleteAllShopsOfUser(userId).forEach { shopId ->
            productRepository.deleteAllProductsOfShop(shopId).forEach { productId ->
                reviewRepository.deleteAllReviewsOfProduct(productId)
            }
        }
    }
}
