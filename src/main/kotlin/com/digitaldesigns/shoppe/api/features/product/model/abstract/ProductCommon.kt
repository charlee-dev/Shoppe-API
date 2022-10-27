package com.digitaldesigns.shoppe.api.features.product.model.abstract

import com.digitaldesigns.shoppe.api.domain.models.TimeTrackable
import com.digitaldesigns.shoppe.api.features.product.model.shared.ProductAttribute
import com.digitaldesigns.shoppe.api.features.product.model.shared.ProductCategory
import com.digitaldesigns.shoppe.api.features.product.model.shared.ProductImage
import com.digitaldesigns.shoppe.api.features.product.model.shared.ProductTag
import com.digitaldesigns.shoppe.api.features.product.model.shared.ProductVariation
import com.digitaldesigns.shoppe.api.graphql.GraphQLDesc
import com.expediagroup.graphql.generator.annotations.GraphQLDescription
import io.ktor.util.date.getTimeMillis
import java.util.Collections

data class ProductCommon(
    @GraphQLDescription(GraphQLDesc.Product.Common.name) val name: String,
    @GraphQLDescription(GraphQLDesc.Product.Common.desc) var desc: String,
    @GraphQLDescription(GraphQLDesc.Product.Common.slug) val slug: String,
    @GraphQLDescription(GraphQLDesc.Product.Common.created) override val created: String = getTimeMillis().toString(),
    @GraphQLDescription(GraphQLDesc.Product.Common.modified) override var modified: String = created,
    @GraphQLDescription(GraphQLDesc.Product.Common.categories) val categories: List<ProductCategory>,
    @GraphQLDescription(GraphQLDesc.Product.Common.tags) val tags: List<ProductTag>,
    @GraphQLDescription(GraphQLDesc.Product.Common.isFeatured) val isFeatured: Boolean,
    @GraphQLDescription(GraphQLDesc.Product.Common.totalSales) val totalSales: Int = 0,
    @GraphQLDescription(GraphQLDesc.Product.Common.allowReviews) val allowReviews: Boolean = true,
    @GraphQLDescription(GraphQLDesc.Product.Common.averageRating) val averageRating: Double = 0.0,
    @GraphQLDescription(GraphQLDesc.Product.Common.numRatings) val numRatings: Int = 0,
    @GraphQLDescription(GraphQLDesc.Product.Common.relatedIds) val relatedIds: List<String>,
    @GraphQLDescription(GraphQLDesc.Product.Common.attributes) val attributes: List<ProductAttribute> = emptyList(),
    @GraphQLDescription(GraphQLDesc.Product.Common.links) val links: List<String> = emptyList(),
    @GraphQLDescription(GraphQLDesc.Product.Common.images) val images: List<ProductImage>,
    @GraphQLDescription(GraphQLDesc.Product.Common.productVariations) val productVariations: List<ProductVariation> = Collections.emptyList(),
    @GraphQLDescription(GraphQLDesc.Product.Common.colors) val colors: List<String>,
) : TimeTrackable
