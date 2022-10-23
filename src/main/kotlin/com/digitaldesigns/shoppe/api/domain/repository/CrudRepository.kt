package com.digitaldesigns.shoppe.api.domain.repository

import com.digitaldesigns.shoppe.api.domain.models.Model
import com.digitaldesigns.shoppe.api.domain.util.Constants
import com.digitaldesigns.shoppe.api.domain.util.doSafely
import com.mongodb.client.MongoCollection
import graphql.GraphQLException
import org.litote.kmongo.eq
import org.litote.kmongo.findOne
import org.litote.kmongo.updateOne

interface CrudRepository<T : Model> {
    var col: MongoCollection<T>

    fun getById(id: String): T {
        return col.findOne(Model::id eq id)
            ?: throw GraphQLException(Constants.Messages.NO_ITEM_WITH_ID + id)
    }

    fun getAll(): List<T> {
        return col.find().asIterable().map { it }
    }

    fun delete(id: String): Boolean = doSafely {
        col.findOneAndDelete(Model::id eq id)
            ?: throw GraphQLException(Constants.Messages.NO_ITEM_WITH_ID + id)
        true
    }

    fun add(entry: T): T = doSafely {
        col.insertOne(entry)
        getById(entry.id)
    }

    fun update(entry: Model): T = doSafely {
        col.updateOne(
            Model::id eq entry.id,
            entry,
            updateOnlyNotNullProperties = true
        )
        getById(entry.id)
    }
}
