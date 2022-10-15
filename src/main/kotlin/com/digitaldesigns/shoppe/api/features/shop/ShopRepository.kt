package com.digitaldesigns.shoppe.api.features.shop

import com.digitaldesigns.shoppe.api.domain.models.PageInput
import com.digitaldesigns.shoppe.api.domain.repository.CrudRepository
import com.digitaldesigns.shoppe.api.domain.util.Constants
import com.digitaldesigns.shoppe.api.domain.util.doSafely
import com.digitaldesigns.shoppe.api.domain.util.inPages
import com.mongodb.client.MongoClient
import com.mongodb.client.MongoCollection
import org.litote.kmongo.eq
import org.litote.kmongo.getCollection
import org.litote.kmongo.or

class ShopRepository(client: MongoClient) : CrudRepository<Shop> {
    override lateinit var col: MongoCollection<Shop>

    init {
        val database = client.getDatabase(Constants.DATABASE_NAME)
        col = database.getCollection<Shop>(Constants.SHOPS_COLLECTION)
    }

    fun queryShopByNamePaged(query: String, pageInput: PageInput): ShopPage = doSafely {
        val filter = or(listOf(Shop::name eq query, Shop::description eq query))
        col.inPages(filter, pageInput).toShopPage()
    }

    fun getAllByUserIdPaged(userId: String, pageInput: PageInput): ShopPage = doSafely {
        val filter = Shop::ownerId eq userId
        col.inPages(filter, pageInput).toShopPage()
    }

    fun getAllByUserId(userId: String): List<Shop> = doSafely {
        val filter = Shop::ownerId eq userId
        col.find(filter).toList()
    }

    fun deleteAllShopsOfUser(userId: String): List<String> {
        val filter = Shop::ownerId eq userId
        val shopIds = col.find(filter).toList().map(Shop::id)
        shopIds.forEach { delete(it) }
        return shopIds
    }
}
