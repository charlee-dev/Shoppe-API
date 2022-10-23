package com.digitaldesigns.shoppe.api.features.product.model

import com.digitaldesigns.shoppe.api.graphql.GraphQLDesc
import com.expediagroup.graphql.generator.annotations.GraphQLDescription

enum class StockStatus { IN_STOCK, OUT_OF_STOCK, ON_BACK_ORDER }

@GraphQLDescription(GraphQLDesc.SortOrder.model)
enum class SortOrder {
    @GraphQLDescription(GraphQLDesc.SortOrder.asc)
    ASC,

    @GraphQLDescription(GraphQLDesc.SortOrder.desc)
    DESC,
}

enum class MeasureUnit {
    MM, CM, M, INCH, FOOT
}

enum class WeightUnit {
    G, KG, STONE, POUND, LBS
}
