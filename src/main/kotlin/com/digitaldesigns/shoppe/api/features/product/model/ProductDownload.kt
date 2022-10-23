package com.digitaldesigns.shoppe.api.features.product.model

import com.digitaldesigns.shoppe.api.domain.models.Model
import com.digitaldesigns.shoppe.api.domain.util.generateId
import com.digitaldesigns.shoppe.api.graphql.GraphQLDesc
import com.expediagroup.graphql.generator.annotations.GraphQLDescription

@GraphQLDescription(GraphQLDesc.ProductDownload.model)
data class ProductDownload(
    @GraphQLDescription(GraphQLDesc.ProductDownload.id)
    override val id: String = generateId(),
    @GraphQLDescription(GraphQLDesc.ProductDownload.name)
    var name: String,
    @GraphQLDescription(GraphQLDesc.ProductDownload.url)
    var url: String,
) : Model
