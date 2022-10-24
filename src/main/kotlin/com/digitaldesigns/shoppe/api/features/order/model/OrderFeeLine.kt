package com.digitaldesigns.shoppe.api.features.order.model

import com.digitaldesigns.shoppe.api.graphql.GraphQLDesc
import com.expediagroup.graphql.generator.annotations.GraphQLDescription

@GraphQLDescription(GraphQLDesc.OrderFeeLine.model)
data class OrderFeeLine(
    @GraphQLDescription(GraphQLDesc.OrderFeeLine.name)
    val name: String,
    @GraphQLDescription(GraphQLDesc.OrderFeeLine.taxClass)
    val taxClass: String,
    @GraphQLDescription(GraphQLDesc.OrderFeeLine.taxStatus)
    val taxStatus: TaxStatus,
    @GraphQLDescription(GraphQLDesc.OrderFeeLine.amount)
    val amount: String,
    @GraphQLDescription(GraphQLDesc.OrderFeeLine.total)
    val total: String,
    @GraphQLDescription(GraphQLDesc.OrderFeeLine.totalTax)
    val totalTax: String,
    @GraphQLDescription(GraphQLDesc.OrderFeeLine.taxes)
    val taxes: List<OrderItemTax>,
)

enum class TaxStatus { TAXABLE, NONE }
