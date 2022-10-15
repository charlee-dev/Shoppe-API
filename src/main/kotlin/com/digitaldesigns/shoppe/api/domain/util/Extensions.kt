package com.digitaldesigns.shoppe.api.domain.util

import at.favre.lib.crypto.bcrypt.BCrypt
import com.digitaldesigns.shoppe.api.domain.models.Page
import com.digitaldesigns.shoppe.api.domain.models.PageInput
import com.digitaldesigns.shoppe.api.domain.models.PagingInfo
import com.mongodb.client.MongoCollection
import graphql.GraphQLException
import graphql.schema.DataFetchingEnvironment
import org.bson.conversions.Bson
import java.nio.charset.StandardCharsets
import java.util.UUID

fun <T> DataFetchingEnvironment.withCurrentUser(block: (userId: String) -> T): T {
    val userId = graphQlContext.get<String>("id") ?: error(Constants.Messages.NOT_SIGNED_IN)
    return block(userId)
}

fun generateId(): String = UUID.randomUUID().toString()

fun <T> checkPermissions(productUserId: String, currentUserId: String, block: () -> T): T {
    return if (productUserId == currentUserId) {
        block()
    } else {
        error(Constants.Messages.INSUFFICIENT_PERMISSIONS)
    }
}

fun String.encrypt(): ByteArray =
    BCrypt.withDefaults().hash(10, this.toByteArray(StandardCharsets.UTF_8))

fun String.trimWhitespaces(): String = replace("\\s".toRegex(), "")

fun <T> MongoCollection<T>.inPages(filter: Bson, pageInput: PageInput): Page<T> {
    val skips = pageInput.skips()
    val results = find(filter).skip(skips).limit(pageInput.size)
    val documents = results.asIterable().toList()
    val totalDocuments = countDocuments(filter)
    val pages = totalDocuments % pageInput.size
    val totalPages = if (pages.toInt() != 0) {
        (totalDocuments / pageInput.size) + 1
    } else {
        totalDocuments / pageInput.size
    }
    val next = if (documents.isNotEmpty()) pageInput.page + 1 else null
    val prev = if (pageInput.page > 0) pageInput.page - 1 else null
    val info = PagingInfo(totalDocuments.toInt(), totalPages.toInt(), next, prev)
    return Page(documents, info)
}

@Throws
fun <T> doSafely(block: () -> T): T {
    return try {
        block()
    } catch (t: Throwable) {
        throw GraphQLException("Cannot get items ${t.message}")
    }
}
