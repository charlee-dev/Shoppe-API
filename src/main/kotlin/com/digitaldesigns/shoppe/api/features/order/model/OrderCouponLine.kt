package com.digitaldesigns.shoppe.api.features.order.model

import com.digitaldesigns.shoppe.api.graphql.GraphQLDesc
import com.expediagroup.graphql.generator.annotations.GraphQLDescription

@GraphQLDescription(GraphQLDesc.OrderCouponLine.model)
data class OrderCouponLine(
    @GraphQLDescription(GraphQLDesc.OrderCouponLine.code)
    val code: String = "",
    @GraphQLDescription(GraphQLDesc.OrderCouponLine.discount)
    val discount: String = "",
    @GraphQLDescription(GraphQLDesc.OrderCouponLine.discountTax)
    val discountTax: String = "",
)
