package com.digitaldesigns.shoppe.api.features.order.model

import com.digitaldesigns.shoppe.api.graphql.GraphQLDesc
import com.expediagroup.graphql.generator.annotations.GraphQLDescription

@GraphQLDescription(GraphQLDesc.Order.TaxRate.model)
data class OrderTaxRate(
    @GraphQLDescription(GraphQLDesc.Order.TaxRate.rateCode)
    val rateCode: String,
    @GraphQLDescription(GraphQLDesc.Order.TaxRate.rateId)
    val rateId: String,
    @GraphQLDescription(GraphQLDesc.Order.TaxRate.label)
    val label: String,
    @GraphQLDescription(GraphQLDesc.Order.TaxRate.compoundRate)
    val compoundRate: Boolean,
    @GraphQLDescription(GraphQLDesc.Order.TaxRate.taxTotal)
    val taxTotal: String,
    @GraphQLDescription(GraphQLDesc.Order.TaxRate.shippingTaxTotal)
    val shippingTaxTotal: String,
    @GraphQLDescription(GraphQLDesc.Order.TaxRate.ratePercent)
    val ratePercent: Double,
)
