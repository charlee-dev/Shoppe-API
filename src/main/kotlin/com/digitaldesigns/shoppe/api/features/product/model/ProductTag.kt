package com.digitaldesigns.shoppe.api.features.product.model

import com.digitaldesigns.shoppe.api.graphql.GraphQLDesc
import com.expediagroup.graphql.generator.annotations.GraphQLDescription
import io.ktor.util.date.getTimeMillis

@GraphQLDescription(GraphQLDesc.ProductTag.model)
data class ProductTag(
    @GraphQLDescription(GraphQLDesc.ProductTag.name)
    var name: String,
    @GraphQLDescription(GraphQLDesc.ProductTag.isCustom)
    var isCustom: Boolean,
    @GraphQLDescription(GraphQLDesc.ProductTag.createdDate)
    val createdDate: String = getTimeMillis().toString(), // Date
    @GraphQLDescription(GraphQLDesc.ProductTag.createdBy)
    val createdBy: String,
)
