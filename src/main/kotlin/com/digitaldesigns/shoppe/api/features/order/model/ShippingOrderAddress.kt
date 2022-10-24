package com.digitaldesigns.shoppe.api.features.order.model

import com.digitaldesigns.shoppe.api.domain.models.Address
import com.digitaldesigns.shoppe.api.graphql.GraphQLDesc
import com.expediagroup.graphql.generator.annotations.GraphQLDescription

@GraphQLDescription(GraphQLDesc.ShippingOrderAddress.model)
data class ShippingOrderAddress(
    @GraphQLDescription(GraphQLDesc.ShippingOrderAddress.firstName)
    override val firstName: String,
    @GraphQLDescription(GraphQLDesc.ShippingOrderAddress.lastName)
    override val lastName: String,
    @GraphQLDescription(GraphQLDesc.ShippingOrderAddress.company)
    override val company: String,
    @GraphQLDescription(GraphQLDesc.ShippingOrderAddress.address1)
    override val address1: String,
    @GraphQLDescription(GraphQLDesc.ShippingOrderAddress.address2)
    override val address2: String,
    @GraphQLDescription(GraphQLDesc.ShippingOrderAddress.city)
    override val city: String,
    @GraphQLDescription(GraphQLDesc.ShippingOrderAddress.state)
    override val state: String,
    @GraphQLDescription(GraphQLDesc.ShippingOrderAddress.postCode)
    override val postCode: String,
    @GraphQLDescription(GraphQLDesc.ShippingOrderAddress.country)
    override val country: String,
) : Address
