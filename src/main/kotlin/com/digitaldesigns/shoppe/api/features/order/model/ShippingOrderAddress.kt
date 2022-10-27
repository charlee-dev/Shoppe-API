package com.digitaldesigns.shoppe.api.features.order.model

import com.digitaldesigns.shoppe.api.domain.models.Address
import com.digitaldesigns.shoppe.api.graphql.GraphQLDesc
import com.expediagroup.graphql.generator.annotations.GraphQLDescription

@GraphQLDescription(GraphQLDesc.Order.ShippingAddress.model)
data class ShippingOrderAddress(
    @GraphQLDescription(GraphQLDesc.Order.ShippingAddress.firstName)
    override val firstName: String,
    @GraphQLDescription(GraphQLDesc.Order.ShippingAddress.lastName)
    override val lastName: String,
    @GraphQLDescription(GraphQLDesc.Order.ShippingAddress.company)
    override val company: String,
    @GraphQLDescription(GraphQLDesc.Order.ShippingAddress.address1)
    override val address1: String,
    @GraphQLDescription(GraphQLDesc.Order.ShippingAddress.address2)
    override val address2: String,
    @GraphQLDescription(GraphQLDesc.Order.ShippingAddress.city)
    override val city: String,
    @GraphQLDescription(GraphQLDesc.Order.ShippingAddress.state)
    override val state: String,
    @GraphQLDescription(GraphQLDesc.Order.ShippingAddress.postCode)
    override val postCode: String,
    @GraphQLDescription(GraphQLDesc.Order.ShippingAddress.country)
    override val country: String,
) : Address
