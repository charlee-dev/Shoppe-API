package com.digitaldesigns.shoppe.api.features.order.model

import com.digitaldesigns.shoppe.api.graphql.GraphQLDesc
import com.expediagroup.graphql.generator.annotations.GraphQLDescription

@GraphQLDescription(GraphQLDesc.Order.Status.model)
enum class OrderStatus {
    PENDING,
    PROCESSING,
    COMPLETE,
    ON_HOLD,
    REFUNDED,
    CANCELLED,
    FAILED,
    TRASH,
}
