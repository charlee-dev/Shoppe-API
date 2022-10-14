package com.digitaldesigns.shoppe.api.features.shop

import com.digitaldesigns.shoppe.api.domain.models.PageInput
import com.digitaldesigns.shoppe.api.domain.util.checkPermissions
import com.digitaldesigns.shoppe.api.features.product.ProductRepository
import com.digitaldesigns.shoppe.api.features.review.ReviewRepository

class ShopService(
    private val shopRepository: ShopRepository,
    private val productRepository: ProductRepository,
    private val reviewRepository: ReviewRepository,
) {
    fun getShopsByQuery(query: String, pageInput: PageInput): ShopPage {
        return shopRepository.queryShopByNamePaged(query, pageInput)
    }

    fun getShopsByUserId(userId: String, pageInput: PageInput): ShopPage {
        return shopRepository.getAllByUserIdPaged(userId, pageInput)
    }

    fun addShop(userId: String, shopInput: ShopInput): Shop {
        shopInput.validate()
        return shopRepository.add(shopInput.toModel(userId))
    }

    fun updateShop(
        userId: String,
        shopId: String,
        shopUpdateInput: ShopInput,
    ): Shop {
        shopUpdateInput.validate()
        val shop = shopRepository.getById(shopId)
        return checkPermissions(userId, shop.ownerId) {
            shopRepository.update(shopUpdateInput.toModel(userId))
        }
    }

    fun deleteShop(userId: String, shopId: String): Boolean {
        val shop = shopRepository.getById(shopId)
        return checkPermissions(userId, shop.ownerId) {
            deleteLinkedProducts(shopId)
            shopRepository.delete(shopId)
        }
    }

    private fun deleteLinkedProducts(shopId: String) {
        productRepository.deleteAllProductsOfShop(shopId).forEach { productId ->
            reviewRepository.deleteAllReviewsOfProduct(productId)
        }
    }

    fun getShopById(shopId: String): Shop {
        return shopRepository.getById(shopId)
    }
}
