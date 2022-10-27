package com.digitaldesigns.shoppe.api.features.product.model.shared

import com.digitaldesigns.shoppe.api.domain.models.Model
import com.digitaldesigns.shoppe.api.domain.util.generateId
import com.digitaldesigns.shoppe.api.graphql.GraphQLDesc
import com.expediagroup.graphql.generator.annotations.GraphQLDescription

@GraphQLDescription(GraphQLDesc.Product.Download.model)
data class ProductDownload(
    @GraphQLDescription(GraphQLDesc.Product.Download.id)
    override val id: String = generateId(),
    @GraphQLDescription(GraphQLDesc.Product.Download.name)
    var name: String,
    @GraphQLDescription(GraphQLDesc.Product.Download.url)
    var url: String,
) : Model
