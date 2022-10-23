package com.digitaldesigns.shoppe.api.features.product.model

import com.digitaldesigns.shoppe.api.graphql.GraphQLDesc
import com.expediagroup.graphql.generator.annotations.GraphQLDescription

@GraphQLDescription(GraphQLDesc.ProductAttribute.model)
data class ProductAttribute(
    @GraphQLDescription(GraphQLDesc.ProductAttribute.sortOrder)
    var sortOrder: SortOrder = SortOrder.ASC,
    @GraphQLDescription(GraphQLDesc.ProductAttribute.isVisibleOnProductPage)
    var isVisibleOnProductPage: Boolean = false,
    @GraphQLDescription(GraphQLDesc.ProductAttribute.isForVariations)
    var isForVariations: Boolean = false,
    @GraphQLDescription(GraphQLDesc.ProductAttribute.options)
    var options: List<String> = emptyList(),
)

@GraphQLDescription(GraphQLDesc.ProductAttribute.input)
data class ProductAttributeInput(
    @GraphQLDescription(GraphQLDesc.ProductAttribute.sortOrder)
    val sortOrder: SortOrder? = null,
    @GraphQLDescription(GraphQLDesc.ProductAttribute.isVisibleOnProductPage)
    val isVisibleOnProductPage: Boolean? = null,
    @GraphQLDescription(GraphQLDesc.ProductAttribute.isForVariations)
    val isForVariations: Boolean? = null,
    @GraphQLDescription(GraphQLDesc.ProductAttribute.options)
    val options: List<String>? = null,
)
