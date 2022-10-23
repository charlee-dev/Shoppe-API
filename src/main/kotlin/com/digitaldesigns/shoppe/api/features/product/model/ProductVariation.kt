package com.digitaldesigns.shoppe.api.features.product.model

import com.digitaldesigns.shoppe.api.domain.models.Model
import com.digitaldesigns.shoppe.api.domain.models.TimeTrackable
import com.digitaldesigns.shoppe.api.domain.util.generateId
import com.digitaldesigns.shoppe.api.graphql.GraphQLDesc
import com.expediagroup.graphql.generator.annotations.GraphQLDescription
import io.ktor.util.date.getTimeMillis

data class ProductVariation(
    @GraphQLDescription(GraphQLDesc.Product.variationId) override val id: String = generateId(),
    @GraphQLDescription(GraphQLDesc.Product.created) override val created: String = getTimeMillis().toString(),
    @GraphQLDescription(GraphQLDesc.Product.modified) override var modified: String = created,
    @GraphQLDescription(GraphQLDesc.Product.attributes) val attributes: List<ProductAttribute> = emptyList(),
    @GraphQLDescription(GraphQLDesc.Product.image) val image: ProductImage = ProductImage(),
    @GraphQLDescription(GraphQLDesc.Product.price) var price: Double,
    @GraphQLDescription(GraphQLDesc.Product.regularPrice) var regularPrice: Double = price,
    @GraphQLDescription(GraphQLDesc.Product.onSale) var onSale: Boolean = false,
    @GraphQLDescription(GraphQLDesc.Product.salePrice) var salePrice: Double = price,
    @GraphQLDescription(GraphQLDesc.Product.saleStart) var saleStart: String = "", // Date
    @GraphQLDescription(GraphQLDesc.Product.saleEnd) var saleEnd: String = "", // Date
    @GraphQLDescription(GraphQLDesc.Product.remainingStock) var remainingStock: Int = 0,
    @GraphQLDescription(GraphQLDesc.Product.totalSales) var totalSales: Int = 0,
) : Model, TimeTrackable
