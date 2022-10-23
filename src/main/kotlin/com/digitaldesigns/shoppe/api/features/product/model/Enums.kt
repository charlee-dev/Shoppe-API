package com.digitaldesigns.shoppe.api.features.product.model

import com.digitaldesigns.shoppe.api.graphql.GraphQLDesc
import com.expediagroup.graphql.generator.annotations.GraphQLDescription

@GraphQLDescription(GraphQLDesc.Product.CatalogVisibility.model)
enum class PostStatus { DRAFT, PENDING, PRIVATE, PUBLISH }

@GraphQLDescription(GraphQLDesc.Product.CatalogVisibility.model)
enum class CatalogVisibility {
    @GraphQLDescription(GraphQLDesc.Product.CatalogVisibility.everywhere)
    EVERYWHERE,

    @GraphQLDescription(GraphQLDesc.Product.CatalogVisibility.hidden)
    HIDDEN
}

enum class StockStatus { IN_STOCK, OUT_OF_STOCK, ON_BACK_ORDER }

@GraphQLDescription(GraphQLDesc.Product.BackorderStatus.model)
enum class BackorderStatus {
    @GraphQLDescription(GraphQLDesc.Product.BackorderStatus.allowed)
    ALLOWED,

    @GraphQLDescription(GraphQLDesc.Product.BackorderStatus.notAllowed)
    NOT_ALLOWED
}

@Suppress("SpellCheckingInspection")
@GraphQLDescription(GraphQLDesc.Product.Taxability.model)
enum class Taxability {
    @GraphQLDescription(GraphQLDesc.Product.Taxability.productAndShipping)
    PRODUCT_AND_SHIPPING,

    @GraphQLDescription(GraphQLDesc.Product.Taxability.shippingOnly)
    SHIPPING_ONLY,

    @GraphQLDescription(GraphQLDesc.Product.Taxability.none)
    NONE,
}

@GraphQLDescription(GraphQLDesc.Product.SortOrder.model)
enum class SortOrder {
    @GraphQLDescription(GraphQLDesc.Product.SortOrder.asc)
    ASC,

    @GraphQLDescription(GraphQLDesc.Product.SortOrder.desc)
    DESC,
}

enum class MeasureUnit {
    MM, CM, M, INCH, FOOT
}

enum class WeightUnit {
    G, KG, STONE, POUND, LBS
}
