package com.digitaldesigns.shoppe.api.features.product.model.abstract

import com.digitaldesigns.shoppe.api.graphql.GraphQLDesc
import com.expediagroup.graphql.generator.annotations.GraphQLDescription

data class ProductPrice(
    @GraphQLDescription(GraphQLDesc.Product.Price.price) val price: Double,
    @GraphQLDescription(GraphQLDesc.Product.Price.regularPrice) val regularPrice: Double = price,
    @GraphQLDescription(GraphQLDesc.Product.Price.onSale) val onSale: Boolean = false,
    @GraphQLDescription(GraphQLDesc.Product.Price.salePrice) val salePrice: Double = price,
    @GraphQLDescription(GraphQLDesc.Product.Price.saleStart) val saleStart: String? = null,
    @GraphQLDescription(GraphQLDesc.Product.Price.saleEnd) val saleEnd: String? = null,
)
