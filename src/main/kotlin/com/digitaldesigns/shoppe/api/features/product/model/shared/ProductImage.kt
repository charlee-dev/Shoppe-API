package com.digitaldesigns.shoppe.api.features.product.model.shared

import com.digitaldesigns.shoppe.api.domain.models.Model
import com.digitaldesigns.shoppe.api.domain.models.TimeTrackable
import com.digitaldesigns.shoppe.api.domain.util.generateId
import com.digitaldesigns.shoppe.api.graphql.GraphQLDesc
import com.expediagroup.graphql.generator.annotations.GraphQLDescription

@GraphQLDescription(GraphQLDesc.Product.Image.model)
data class ProductImage(
    @GraphQLDescription(GraphQLDesc.Product.Image.id) override val id: String = generateId(),
    @GraphQLDescription(GraphQLDesc.Product.Image.created) override val created: String = "",
    @GraphQLDescription(GraphQLDesc.Product.Image.modified) override var modified: String = "",
    @GraphQLDescription(GraphQLDesc.Product.Image.url) var url: String = "",
    @GraphQLDescription(GraphQLDesc.Product.Image.name) var name: String = "",
    @GraphQLDescription(GraphQLDesc.Product.Image.altText) var altText: String = "",
) : Model, TimeTrackable
