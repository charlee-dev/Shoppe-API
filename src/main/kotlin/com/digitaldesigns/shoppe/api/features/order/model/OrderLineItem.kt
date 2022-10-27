package com.digitaldesigns.shoppe.api.features.order.model

import com.digitaldesigns.shoppe.api.graphql.GraphQLDesc
import com.expediagroup.graphql.generator.annotations.GraphQLDescription

@GraphQLDescription(GraphQLDesc.Order.LineItem.model)
data class OrderLineItem(
    @GraphQLDescription(GraphQLDesc.Order.LineItem.name)
    val name: String,
    @GraphQLDescription(GraphQLDesc.Order.LineItem.productId)
    val productId: String,
    @GraphQLDescription(GraphQLDesc.Order.LineItem.variationId)
    val variationId: String,
    @GraphQLDescription(GraphQLDesc.Order.LineItem.quantity)
    val quantity: Int,
    @GraphQLDescription(GraphQLDesc.Order.LineItem.taxClass)
    val taxClass: String,
    @GraphQLDescription(GraphQLDesc.Order.LineItem.subtotal)
    val subtotal: Double,
    @GraphQLDescription(GraphQLDesc.Order.LineItem.subtotalTax)
    val subtotalTax: Double,
    @GraphQLDescription(GraphQLDesc.Order.LineItem.total)
    val total: Double,
    @GraphQLDescription(GraphQLDesc.Order.LineItem.totalTax)
    val totalTax: Double,
    @GraphQLDescription(GraphQLDesc.Order.LineItem.taxes)
    val taxes: List<OrderItemTax>,
    @GraphQLDescription(GraphQLDesc.Order.LineItem.sku)
    val sku: String,
    @GraphQLDescription(GraphQLDesc.Order.LineItem.price)
    val price: Double,
    @GraphQLDescription(GraphQLDesc.Order.LineItem.parentName)
    val parentName: String,
)
