package com.digitaldesigns.shoppe.api.features.product.model

import com.digitaldesigns.shoppe.api.domain.models.Model
import com.digitaldesigns.shoppe.api.domain.models.TimeTrackable
import com.digitaldesigns.shoppe.api.domain.util.generateId
import com.digitaldesigns.shoppe.api.graphql.GraphQLDesc
import com.expediagroup.graphql.generator.annotations.GraphQLDescription

@GraphQLDescription(GraphQLDesc.ProductImage.model)
data class ProductImage(
    @GraphQLDescription(GraphQLDesc.ProductImage.id)
    override val id: String = generateId(),
    @GraphQLDescription(GraphQLDesc.ProductImage.created)
    override val created: String = "",
    @GraphQLDescription(GraphQLDesc.ProductImage.modified)
    override var modified: String = "",
    @GraphQLDescription(GraphQLDesc.ProductImage.url)
    var url: String = "",
    @GraphQLDescription(GraphQLDesc.ProductImage.name)
    var name: String = "",
    @GraphQLDescription(GraphQLDesc.ProductImage.altText)
    var altText: String = "",
) : Model, TimeTrackable
