package com.digitaldesigns.shoppe.api.features.product.model.abstract

import com.digitaldesigns.shoppe.api.graphql.GraphQLDesc
import com.expediagroup.graphql.generator.annotations.GraphQLDescription

data class ProductCrossSell(
    @GraphQLDescription(GraphQLDesc.Product.CrossSell.productIds) val productIds: List<String>,
)
