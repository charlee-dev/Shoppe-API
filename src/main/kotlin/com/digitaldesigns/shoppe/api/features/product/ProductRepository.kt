package com.digitaldesigns.shoppe.api.features.product

import com.digitaldesigns.shoppe.api.domain.models.PageInput
import com.digitaldesigns.shoppe.api.domain.repository.CrudRepository
import com.digitaldesigns.shoppe.api.domain.util.Constants
import com.digitaldesigns.shoppe.api.domain.util.doSafely
import com.digitaldesigns.shoppe.api.domain.util.inPages
import com.digitaldesigns.shoppe.api.features.product.model.Product
import com.digitaldesigns.shoppe.api.features.product.model.ProductPage
import com.digitaldesigns.shoppe.api.features.product.model.abstract.ProductCommon
import com.digitaldesigns.shoppe.api.features.product.model.shared.ProductCategory
import com.digitaldesigns.shoppe.api.features.product.model.toProductPage
import com.mongodb.client.MongoClient
import com.mongodb.client.MongoCollection
import org.litote.kmongo.div
import org.litote.kmongo.eq
import org.litote.kmongo.getCollection
import org.litote.kmongo.or

class ProductRepository(client: MongoClient) : CrudRepository<Product> {
    override lateinit var col: MongoCollection<Product>

    init {
        val database = client.getDatabase(Constants.DATABASE_NAME)
        col = database.getCollection<Product>(Constants.PRODUCTS_COLLECTION)
    }

    fun queryProductNameByPaged(query: String, pageInput: PageInput): ProductPage = doSafely {
        val filter = or(
            listOf(
                Product::common / ProductCommon::name eq query,
                Product::common / ProductCommon::desc eq query,
            )
        )
        col.inPages(filter, pageInput).toProductPage()
    }

    fun getAllByUserIdPaged(userId: String, pageInput: PageInput): ProductPage = doSafely {
        val filter = Product::userId eq userId
        col.inPages(filter, pageInput).toProductPage()
    }

    fun getAllByUserId(userId: String): List<Product> = doSafely {
        val filter = Product::userId eq userId
        col.find(filter).toList()
    }

    fun getAllByCategoryPaged(category: ProductCategory, pageInput: PageInput): ProductPage = doSafely {
//        val filter = Product::categories eq category // FIXME: fix get categories
        val filter = Product::userId eq "userId"
        col.inPages(filter, pageInput).toProductPage()
    }

    fun getAllProductsForShop(shopId: String): List<Product> = doSafely {
        col.find(Product::shopId eq shopId).toList()
    }

    fun getProductsByShopId(shopId: String, pageInput: PageInput): ProductPage = doSafely {
        val filter = Product::shopId eq shopId
        col.inPages(filter, pageInput).toProductPage()
    }

    fun deleteAllProductsOfShop(shopId: String): List<String> {
        val filter = Product::shopId eq shopId
        val productIds = col.find(filter).toList().map(Product::id)
        productIds.forEach { delete(it) }
        return productIds
    }
}
