package com.digitaldesigns.shoppe.api.features.product.model.classes

import com.digitaldesigns.shoppe.api.features.product.model.SortOrder
import com.digitaldesigns.shoppe.api.graphql.GraphQLDesc
import com.expediagroup.graphql.generator.annotations.GraphQLDescription

@GraphQLDescription(GraphQLDesc.Product.Attribute.model)
data class ProductAttribute(
    @GraphQLDescription(GraphQLDesc.Product.Attribute.sortOrder)
    var sortOrder: SortOrder = SortOrder.ASC,
    @GraphQLDescription(GraphQLDesc.Product.Attribute.isVisibleOnProductPage)
    var isVisibleOnProductPage: Boolean = false,
    @GraphQLDescription(GraphQLDesc.Product.Attribute.isForVariations)
    var isForVariations: Boolean = false,
    @GraphQLDescription(GraphQLDesc.Product.Attribute.options)
    var options: List<String> = emptyList(),
)

@GraphQLDescription(GraphQLDesc.Product.Attribute.input)
data class ProductAttributeInput(
    @GraphQLDescription(GraphQLDesc.Product.Attribute.sortOrder)
    val sortOrder: SortOrder? = null,
    @GraphQLDescription(GraphQLDesc.Product.Attribute.isVisibleOnProductPage)
    val isVisibleOnProductPage: Boolean? = null,
    @GraphQLDescription(GraphQLDesc.Product.Attribute.isForVariations)
    val isForVariations: Boolean? = null,
    @GraphQLDescription(GraphQLDesc.Product.Attribute.options)
    val options: List<String>? = null,
)
