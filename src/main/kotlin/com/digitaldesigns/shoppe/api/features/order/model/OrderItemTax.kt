package com.digitaldesigns.shoppe.api.features.order.model

import com.digitaldesigns.shoppe.api.graphql.GraphQLDesc
import com.expediagroup.graphql.generator.annotations.GraphQLDescription

@GraphQLDescription(GraphQLDesc.OrderItemTax.model)
data class OrderItemTax(
    @GraphQLDescription(GraphQLDesc.OrderItemTax.total)
    var total: Double,
    @GraphQLDescription(GraphQLDesc.OrderItemTax.subtotal)
    var subtotal: Double,
)
