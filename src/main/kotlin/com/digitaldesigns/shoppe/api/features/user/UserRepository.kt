package com.digitaldesigns.shoppe.api.features.user

import com.digitaldesigns.shoppe.api.domain.repository.CrudRepository
import com.digitaldesigns.shoppe.api.domain.util.Constants
import com.digitaldesigns.shoppe.api.domain.util.Constants.DATABASE_NAME
import com.digitaldesigns.shoppe.api.domain.util.Constants.USERS_COLLECTION
import com.mongodb.client.MongoClient
import com.mongodb.client.MongoCollection
import graphql.GraphQLException
import org.litote.kmongo.eq
import org.litote.kmongo.findOne
import org.litote.kmongo.getCollection

class UserRepository(client: MongoClient) : CrudRepository<UserModel> {
    override lateinit var col: MongoCollection<UserModel>

    init {
        val database = client.getDatabase(DATABASE_NAME)
        col = database.getCollection<UserModel>(USERS_COLLECTION)
    }

    fun getUserByEmail(email: String? = null): UserModel? {
        return try {
            col.findOne(UserModel::email eq email)
        } catch (t: Throwable) {
            throw GraphQLException("Cannot get user with that email - ${t.message}")
        }
    }

    fun getMinimalUser(userId: String): UserMinimal {
        return try {
            val user = col.findOne(UserModel::id eq userId) ?: error(
                "Cannot get user with id $userId"
            )
            user.toMinimal()
        } catch (t: Throwable) {
            throw GraphQLException("Cannot get user with that id - ${t.message}")
        }
    }

    infix fun throwIfUserWithThatEmailExists(email: String) {
        val emailUser = getUserByEmail(email)
        if (emailUser != null) {
            throw GraphQLException(Constants.Messages.EMAIL_IN_USE)
        }
    }
}
