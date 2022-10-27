package com.digitaldesigns.shoppe.api.features.order.model

import com.digitaldesigns.shoppe.api.graphql.GraphQLDesc
import com.expediagroup.graphql.generator.annotations.GraphQLDescription

@GraphQLDescription(GraphQLDesc.Order.ItemTax.model)
data class OrderItemTax(
    @GraphQLDescription(GraphQLDesc.Order.ItemTax.total)
    var total: Double,
    @GraphQLDescription(GraphQLDesc.Order.ItemTax.subtotal)
    var subtotal: Double,
)
