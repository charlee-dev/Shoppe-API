package com.digitaldesigns.shoppe.api.features.order

import com.digitaldesigns.shoppe.api.domain.repository.CrudRepository
import com.digitaldesigns.shoppe.api.domain.util.Constants
import com.digitaldesigns.shoppe.api.features.order.model.Order
import com.mongodb.client.MongoClient
import com.mongodb.client.MongoCollection
import org.litote.kmongo.getCollection

class OrderRepository(private val client: MongoClient) : CrudRepository<Order> {

    override lateinit var col: MongoCollection<Order>

    init {
        val database = client.getDatabase(Constants.DATABASE_NAME)
        col = database.getCollection<Order>(Constants.ORDER_COLLECTION)
    }

}
