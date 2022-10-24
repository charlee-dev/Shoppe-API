package com.digitaldesigns.shoppe.api.features.order.model

import com.digitaldesigns.shoppe.api.graphql.GraphQLDesc
import com.expediagroup.graphql.generator.annotations.GraphQLDescription

@GraphQLDescription(GraphQLDesc.OrderLineItem.model)
data class OrderLineItem(
    @GraphQLDescription(GraphQLDesc.OrderLineItem.name)
    val name: String,
    @GraphQLDescription(GraphQLDesc.OrderLineItem.productId)
    val productId: String,
    @GraphQLDescription(GraphQLDesc.OrderLineItem.variationId)
    val variationId: String,
    @GraphQLDescription(GraphQLDesc.OrderLineItem.quantity)
    val quantity: Int,
    @GraphQLDescription(GraphQLDesc.OrderLineItem.taxClass)
    val taxClass: String,
    @GraphQLDescription(GraphQLDesc.OrderLineItem.subtotal)
    val subtotal: Double,
    @GraphQLDescription(GraphQLDesc.OrderLineItem.subtotalTax)
    val subtotalTax: Double,
    @GraphQLDescription(GraphQLDesc.OrderLineItem.total)
    val total: Double,
    @GraphQLDescription(GraphQLDesc.OrderLineItem.totalTax)
    val totalTax: Double,
    @GraphQLDescription(GraphQLDesc.OrderLineItem.taxes)
    val taxes: List<OrderItemTax>,
    @GraphQLDescription(GraphQLDesc.OrderLineItem.sku)
    val sku: String,
    @GraphQLDescription(GraphQLDesc.OrderLineItem.price)
    val price: Double,
    @GraphQLDescription(GraphQLDesc.OrderLineItem.parentName)
    val parentName: String,
)
