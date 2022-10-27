package com.digitaldesigns.shoppe.api.features.product.model.abstract

import com.digitaldesigns.shoppe.api.features.product.model.shared.MeasureUnit
import com.digitaldesigns.shoppe.api.features.product.model.shared.WeightUnit
import com.digitaldesigns.shoppe.api.graphql.GraphQLDesc
import com.expediagroup.graphql.generator.annotations.GraphQLDescription

data class ProductShipping(
    @GraphQLDescription(GraphQLDesc.Product.Shipping.weight) var weight: String,
    @GraphQLDescription(GraphQLDesc.Product.Shipping.weightUnit) var weightUnit: WeightUnit,
    @GraphQLDescription(GraphQLDesc.Product.Shipping.length) var length: String,
    @GraphQLDescription(GraphQLDesc.Product.Shipping.width) var width: String,
    @GraphQLDescription(GraphQLDesc.Product.Shipping.height) var height: String,
    @GraphQLDescription(GraphQLDesc.Product.Shipping.measureUnit) var measureUnit: MeasureUnit,
    @GraphQLDescription(GraphQLDesc.Product.Shipping.requiresShipping) var requiresShipping: String,
    @GraphQLDescription(GraphQLDesc.Product.Shipping.isShippingTaxable) var isShippingTaxable: String,
    @GraphQLDescription(GraphQLDesc.Product.Shipping.shippingClass) var shippingClass: String,
    @GraphQLDescription(GraphQLDesc.Product.Shipping.shippingClassId) var shippingClassId: String,
)
