package com.digitaldesigns.shoppe.api.features.order.model

import com.digitaldesigns.shoppe.api.graphql.GraphQLDesc
import com.expediagroup.graphql.generator.annotations.GraphQLDescription

@GraphQLDescription(GraphQLDesc.Order.FeeLine.model)
data class OrderFeeLine(
    @GraphQLDescription(GraphQLDesc.Order.FeeLine.name)
    val name: String,
    @GraphQLDescription(GraphQLDesc.Order.FeeLine.taxClass)
    val taxClass: String,
    @GraphQLDescription(GraphQLDesc.Order.FeeLine.taxStatus)
    val taxStatus: TaxStatus,
    @GraphQLDescription(GraphQLDesc.Order.FeeLine.amount)
    val amount: String,
    @GraphQLDescription(GraphQLDesc.Order.FeeLine.total)
    val total: String,
    @GraphQLDescription(GraphQLDesc.Order.FeeLine.totalTax)
    val totalTax: String,
    @GraphQLDescription(GraphQLDesc.Order.FeeLine.taxes)
    val taxes: List<OrderItemTax>,
)

enum class TaxStatus { TAXABLE, NONE }
