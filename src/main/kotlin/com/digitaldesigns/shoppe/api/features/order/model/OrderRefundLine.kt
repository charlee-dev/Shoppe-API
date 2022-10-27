package com.digitaldesigns.shoppe.api.features.order.model

import com.digitaldesigns.shoppe.api.graphql.GraphQLDesc
import com.expediagroup.graphql.generator.annotations.GraphQLDescription

@GraphQLDescription(GraphQLDesc.Order.RefundLine.model)
data class OrderRefundLine(
    @GraphQLDescription(GraphQLDesc.Order.RefundLine.reason)
    val reason: String,
    @GraphQLDescription(GraphQLDesc.Order.RefundLine.total)
    val total: String,
)
