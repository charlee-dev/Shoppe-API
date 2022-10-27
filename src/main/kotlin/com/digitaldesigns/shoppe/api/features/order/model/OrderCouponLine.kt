package com.digitaldesigns.shoppe.api.features.order.model

import com.digitaldesigns.shoppe.api.graphql.GraphQLDesc
import com.expediagroup.graphql.generator.annotations.GraphQLDescription

@GraphQLDescription(GraphQLDesc.Order.CouponLine.model)
data class OrderCouponLine(
    @GraphQLDescription(GraphQLDesc.Order.CouponLine.code)
    val code: String = "",
    @GraphQLDescription(GraphQLDesc.Order.CouponLine.discount)
    val discount: String = "",
    @GraphQLDescription(GraphQLDesc.Order.CouponLine.discountTax)
    val discountTax: String = "",
)
