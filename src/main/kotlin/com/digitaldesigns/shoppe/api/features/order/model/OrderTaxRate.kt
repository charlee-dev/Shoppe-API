package com.digitaldesigns.shoppe.api.features.order.model

import com.digitaldesigns.shoppe.api.graphql.GraphQLDesc
import com.expediagroup.graphql.generator.annotations.GraphQLDescription

@GraphQLDescription(GraphQLDesc.OrderTaxRate.model)
data class OrderTaxRate(
    @GraphQLDescription(GraphQLDesc.OrderTaxRate.rateCode)
    val rateCode: String,
    @GraphQLDescription(GraphQLDesc.OrderTaxRate.rateId)
    val rateId: String,
    @GraphQLDescription(GraphQLDesc.OrderTaxRate.label)
    val label: String,
    @GraphQLDescription(GraphQLDesc.OrderTaxRate.compoundRate)
    val compoundRate: Boolean,
    @GraphQLDescription(GraphQLDesc.OrderTaxRate.taxTotal)
    val taxTotal: String,
    @GraphQLDescription(GraphQLDesc.OrderTaxRate.shippingTaxTotal)
    val shippingTaxTotal: String,
    @GraphQLDescription(GraphQLDesc.OrderTaxRate.ratePercent)
    val ratePercent: Double,
)
