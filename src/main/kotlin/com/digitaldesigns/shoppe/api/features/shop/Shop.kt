package com.digitaldesigns.shoppe.api.features.shop

import com.digitaldesigns.shoppe.api.domain.models.Model
import com.digitaldesigns.shoppe.api.domain.models.Page
import com.digitaldesigns.shoppe.api.domain.models.PagingInfo
import com.digitaldesigns.shoppe.api.domain.util.Constants
import com.digitaldesigns.shoppe.api.domain.util.generateId
import com.digitaldesigns.shoppe.api.domain.util.trimWhitespaces
import com.digitaldesigns.shoppe.api.graphql.GraphQLDesc
import com.expediagroup.graphql.generator.annotations.GraphQLDescription
import graphql.GraphQLException
import io.ktor.util.date.getTimeMillis

@GraphQLDescription(GraphQLDesc.Shop.model)
data class Shop(
    @GraphQLDescription(GraphQLDesc.Shop.id)
    override val id: String = generateId(),
    @GraphQLDescription(GraphQLDesc.Shop.name)
    val name: String,
    @GraphQLDescription(GraphQLDesc.Shop.desc)
    val desc: String,
    @GraphQLDescription(GraphQLDesc.Shop.logo)
    val logo: String = "",
    @GraphQLDescription(GraphQLDesc.Shop.ownerId)
    val ownerId: String,
    @GraphQLDescription(GraphQLDesc.Shop.dateCreated)
    val dateCreated: String = getTimeMillis().toString(),
) : Model

@GraphQLDescription(GraphQLDesc.Shop.Input.model)
data class ShopInput(
    @GraphQLDescription(GraphQLDesc.Shop.Input.name)
    val name: String,
    @GraphQLDescription(GraphQLDesc.Shop.Input.description)
    val description: String,
    @GraphQLDescription(GraphQLDesc.Shop.Input.logo)
    val logo: String = "",
) {
    fun validate() {
        name.trimWhitespaces().ifBlank {
            throw GraphQLException(Constants.Messages.CANNOT_BE_BLANK)
        }
    }

    fun toModel(ownerId: String) = Shop(
        name = name,
        desc = description,
        logo = logo,
        ownerId = ownerId
    )
}

@GraphQLDescription(GraphQLDesc.Shop.Page.model)
data class ShopPage(
    @GraphQLDescription(GraphQLDesc.Shop.Page.results)
    val results: List<Shop>,
    @GraphQLDescription(GraphQLDesc.Shop.Page.info)
    val info: PagingInfo,
)

fun Page<Shop>.toShopPage() = ShopPage(
    results = results,
    info = info
)
