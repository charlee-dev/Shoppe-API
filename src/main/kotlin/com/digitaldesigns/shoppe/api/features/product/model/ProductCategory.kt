package com.digitaldesigns.shoppe.api.features.product.model

import com.digitaldesigns.shoppe.api.graphql.GraphQLDesc
import com.expediagroup.graphql.generator.annotations.GraphQLDescription
import io.ktor.util.date.getTimeMillis

@GraphQLDescription(GraphQLDesc.ProductTag.model)
data class ProductCategory(
    @GraphQLDescription(GraphQLDesc.ProductCategory.name)
    var name: String,
    @GraphQLDescription(GraphQLDesc.ProductCategory.isCustom)
    var isCustom: Boolean = true,
    @GraphQLDescription(GraphQLDesc.ProductCategory.createdDate)
    val createdDate: String = getTimeMillis().toString(), // Date
    @GraphQLDescription(GraphQLDesc.ProductCategory.createdBy)
    val createdBy: String,
)
