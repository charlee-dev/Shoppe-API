package com.digitaldesigns.shoppe.api.features.product.model.abstract

import com.digitaldesigns.shoppe.api.features.product.model.shared.ProductDownload
import com.digitaldesigns.shoppe.api.graphql.GraphQLDesc
import com.expediagroup.graphql.generator.annotations.GraphQLDescription

data class ProductDelivery(
    @GraphQLDescription(GraphQLDesc.Product.Delivery.isVirtual) val isVirtual: Boolean,
    @GraphQLDescription(GraphQLDesc.Product.Delivery.isDownloadable) val isDownloadable: Boolean,
    @GraphQLDescription(GraphQLDesc.Product.Delivery.downloads) val downloads: List<ProductDownload>,
    @GraphQLDescription(GraphQLDesc.Product.Delivery.downloadLimit) val downloadLimit: Int,
    @GraphQLDescription(GraphQLDesc.Product.Delivery.daysToDownload) val daysToDownload: Double,
    @GraphQLDescription(GraphQLDesc.Product.Delivery.purchaseNote) val purchaseNote: String,
)
