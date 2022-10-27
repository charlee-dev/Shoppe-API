package com.digitaldesigns.shoppe.api.features.product.model.shared

import com.digitaldesigns.shoppe.api.domain.models.Model
import com.digitaldesigns.shoppe.api.domain.models.TimeTrackable
import com.digitaldesigns.shoppe.api.domain.util.generateId
import com.digitaldesigns.shoppe.api.graphql.GraphQLDesc
import com.expediagroup.graphql.generator.annotations.GraphQLDescription
import io.ktor.util.date.getTimeMillis

@GraphQLDescription(GraphQLDesc.Product.Variation.model)
data class ProductVariation(
    @GraphQLDescription(GraphQLDesc.Product.Variation.variationId) override val id: String = generateId(),
    @GraphQLDescription(GraphQLDesc.Product.Variation.created) override val created: String = getTimeMillis().toString(),
    @GraphQLDescription(GraphQLDesc.Product.Variation.modified) override var modified: String = created,
    @GraphQLDescription(GraphQLDesc.Product.Variation.attributes) val attributes: List<ProductAttribute> = emptyList(),
    @GraphQLDescription(GraphQLDesc.Product.Variation.image) val image: ProductImage = ProductImage(),
    @GraphQLDescription(GraphQLDesc.Product.Variation.price) var price: Double,
    @GraphQLDescription(GraphQLDesc.Product.Variation.regularPrice) var regularPrice: Double = price,
    @GraphQLDescription(GraphQLDesc.Product.Variation.onSale) var onSale: Boolean = false,
    @GraphQLDescription(GraphQLDesc.Product.Variation.salePrice) var salePrice: Double = price,
    @GraphQLDescription(GraphQLDesc.Product.Variation.saleStart) var saleStart: String = "", // Date
    @GraphQLDescription(GraphQLDesc.Product.Variation.saleEnd) var saleEnd: String = "", // Date
    @GraphQLDescription(GraphQLDesc.Product.Variation.remainingStock) var remainingStock: Int = 0,
    @GraphQLDescription(GraphQLDesc.Product.Variation.totalSales) var totalSales: Int = 0,
) : Model, TimeTrackable
