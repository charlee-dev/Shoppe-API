package com.digitaldesigns.shoppe.api.features.order.model

import com.digitaldesigns.shoppe.api.graphql.GraphQLDesc
import com.expediagroup.graphql.generator.annotations.GraphQLDescription

@GraphQLDescription(GraphQLDesc.Order.ShippingLine.model)
data class OrderShippingLine(
    @GraphQLDescription(GraphQLDesc.Order.ShippingLine.methodTitle)
    val methodTitle: String,
    @GraphQLDescription(GraphQLDesc.Order.ShippingLine.methodId)
    val methodId: String,
    @GraphQLDescription(GraphQLDesc.Order.ShippingLine.instanceId)
    val instanceId: String,
    @GraphQLDescription(GraphQLDesc.Order.ShippingLine.total)
    val total: String,
    @GraphQLDescription(GraphQLDesc.Order.ShippingLine.totalTax)
    val totalTax: String,
    @GraphQLDescription(GraphQLDesc.Order.ShippingLine.taxes)
    val taxes: List<OrderItemTax>,
)
