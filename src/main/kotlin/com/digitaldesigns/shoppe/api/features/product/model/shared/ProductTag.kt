package com.digitaldesigns.shoppe.api.features.product.model.shared

import com.digitaldesigns.shoppe.api.graphql.GraphQLDesc
import com.expediagroup.graphql.generator.annotations.GraphQLDescription
import io.ktor.util.date.getTimeMillis

@GraphQLDescription(GraphQLDesc.Product.Tag.model)
data class ProductTag(
    @GraphQLDescription(GraphQLDesc.Product.Tag.name)
    var name: String,
    @GraphQLDescription(GraphQLDesc.Product.Tag.isCustom)
    var isCustom: Boolean,
    @GraphQLDescription(GraphQLDesc.Product.Tag.createdDate)
    val createdDate: String = getTimeMillis().toString(), // Date
    @GraphQLDescription(GraphQLDesc.Product.Tag.createdBy)
    val createdBy: String,
)
