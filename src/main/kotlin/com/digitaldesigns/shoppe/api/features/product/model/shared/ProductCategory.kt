package com.digitaldesigns.shoppe.api.features.product.model.shared

import com.digitaldesigns.shoppe.api.graphql.GraphQLDesc
import com.expediagroup.graphql.generator.annotations.GraphQLDescription
import io.ktor.util.date.getTimeMillis

@GraphQLDescription(GraphQLDesc.Product.Tag.model)
data class ProductCategory(
    @GraphQLDescription(GraphQLDesc.Product.Category.name)
    var name: String,
    @GraphQLDescription(GraphQLDesc.Product.Category.isCustom)
    var isCustom: Boolean = true,
    @GraphQLDescription(GraphQLDesc.Product.Category.createdDate)
    val createdDate: String = getTimeMillis().toString(), // Date
    @GraphQLDescription(GraphQLDesc.Product.Category.createdBy)
    val createdBy: String,
)
