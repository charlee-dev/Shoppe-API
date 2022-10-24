package com.digitaldesigns.shoppe.api.features.order.model

import com.digitaldesigns.shoppe.api.graphql.GraphQLDesc
import com.expediagroup.graphql.generator.annotations.GraphQLDescription

@GraphQLDescription(GraphQLDesc.OrderRefundLine.model)
data class OrderRefundLine(
    @GraphQLDescription(GraphQLDesc.OrderRefundLine.reason)
    val reason: String,
    @GraphQLDescription(GraphQLDesc.OrderRefundLine.total)
    val total: String,
)
