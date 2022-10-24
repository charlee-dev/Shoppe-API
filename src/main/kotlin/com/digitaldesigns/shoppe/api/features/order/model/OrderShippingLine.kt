package com.digitaldesigns.shoppe.api.features.order.model

import com.digitaldesigns.shoppe.api.graphql.GraphQLDesc
import com.expediagroup.graphql.generator.annotations.GraphQLDescription

@GraphQLDescription(GraphQLDesc.OrderShippingLine.model)
data class OrderShippingLine(
    @GraphQLDescription(GraphQLDesc.OrderShippingLine.methodTitle)
    val methodTitle: String,
    @GraphQLDescription(GraphQLDesc.OrderShippingLine.methodId)
    val methodId: String,
    @GraphQLDescription(GraphQLDesc.OrderShippingLine.instanceId)
    val instanceId: String,
    @GraphQLDescription(GraphQLDesc.OrderShippingLine.total)
    val total: String,
    @GraphQLDescription(GraphQLDesc.OrderShippingLine.totalTax)
    val totalTax: String,
    @GraphQLDescription(GraphQLDesc.OrderShippingLine.taxes)
    val taxes: List<OrderItemTax>,
)
