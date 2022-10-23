package com.digitaldesigns.shoppe.api.features.shop

import com.digitaldesigns.shoppe.api.domain.models.Model
import com.digitaldesigns.shoppe.api.domain.models.Page
import com.digitaldesigns.shoppe.api.domain.models.PagingInfo
import com.digitaldesigns.shoppe.api.domain.util.Constants
import com.digitaldesigns.shoppe.api.domain.util.generateId
import com.digitaldesigns.shoppe.api.domain.util.trimWhitespaces
import com.expediagroup.graphql.generator.annotations.GraphQLDescription
import graphql.GraphQLException
import io.ktor.util.date.getTimeMillis

@GraphQLDescription(shopDescription)
data class Shop(
    override val id: String = generateId(),
    val name: String,
    val description: String,
    val logo: String = "",
    val ownerId: String,
    val dateCreated: String = getTimeMillis().toString(),
) : Model

@GraphQLDescription(shopInputDescription)
data class ShopInput(
    val name: String,
    val description: String,
    val logo: String = "",
) {
    fun validate() {
        name.trimWhitespaces().ifBlank {
            throw GraphQLException(Constants.Messages.CANNOT_BE_BLANK)
        }
    }

    fun toModel(ownerId: String) = Shop(
        name = name,
        description = description,
        logo = logo,
        ownerId = ownerId
    )
}

@GraphQLDescription(shopPageDescription)
data class ShopPage(
    val results: List<Shop>,
    val info: PagingInfo
)

fun Page<Shop>.toShopPage() = ShopPage(
    results = results,
    info = info
)

const val shopDescription = "placeholder"
const val shopInputDescription = "placeholder"
const val shopPageDescription = "placeholder"
