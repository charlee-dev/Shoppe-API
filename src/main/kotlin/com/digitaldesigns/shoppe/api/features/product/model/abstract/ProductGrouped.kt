package com.digitaldesigns.shoppe.api.features.product.model.abstract

import com.digitaldesigns.shoppe.api.graphql.GraphQLDesc
import com.expediagroup.graphql.generator.annotations.GraphQLDescription

data class ProductGrouped(
    @GraphQLDescription(GraphQLDesc.Product.Grouped.productIds) val productIds: List<String>,
)
