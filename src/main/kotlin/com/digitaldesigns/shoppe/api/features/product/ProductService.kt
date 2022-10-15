package com.digitaldesigns.shoppe.api.features.product

import com.digitaldesigns.shoppe.api.domain.models.PageInput
import com.digitaldesigns.shoppe.api.domain.util.checkPermissions
import com.digitaldesigns.shoppe.api.features.product.model.Category
import com.digitaldesigns.shoppe.api.features.product.model.Product
import com.digitaldesigns.shoppe.api.features.product.model.ProductBasicInput
import com.digitaldesigns.shoppe.api.features.product.model.ProductPage
import com.digitaldesigns.shoppe.api.features.product.model.ProductUpdateInput
import com.digitaldesigns.shoppe.api.features.review.ReviewRepository

class ProductService(
    private val productRepository: ProductRepository,
    private val reviewRepository: ReviewRepository,
) {
    fun queryAllProductNamesByQuery(query: String, pageInput: PageInput): ProductPage {
        return productRepository.queryProductNameByPaged(query, pageInput)
    }

    fun getProductsByUserId(userId: String, pageInput: PageInput): ProductPage {
        return productRepository.getAllByUserIdPaged(userId, pageInput)
    }

    fun getProductsByCategory(category: Category, pageInput: PageInput): ProductPage {
        return productRepository.getAllByCategoryPaged(category, pageInput)
    }

    fun getProductsByShopId(shopId: String, pageInput: PageInput): ProductPage {
        return productRepository.getProductsByShopId(shopId, pageInput)
    }

    fun addProduct(userId: String, shopId: String, productBasicInput: ProductBasicInput): Product {
        return productRepository.add(productBasicInput.toModel(userId, shopId))
    }

    fun updateProduct(
        userId: String,
        shopId: String,
        productId: String,
        productUpdateInput: ProductUpdateInput,
    ): Product {
        val product = productRepository.getById(productId)
        return checkPermissions(userId, product.userId) {
            productRepository.update(productUpdateInput.toModel(userId, productId, shopId))
        }
    }

    fun deleteProduct(userId: String, productId: String): Boolean {
        val product = productRepository.getById(productId)
        return checkPermissions(userId, product.userId) {
            deleteLinkedReviews(productId)
            productRepository.delete(productId)
        }
    }

    private fun deleteLinkedReviews(productId: String) {
        reviewRepository.deleteAllReviewsOfProduct(productId)
    }
}
