package com.digitaldesigns.shoppe.api.features.product.model.abstract

import com.digitaldesigns.shoppe.api.features.product.model.shared.BackorderStatus
import com.digitaldesigns.shoppe.api.features.product.model.shared.StockStatus
import com.digitaldesigns.shoppe.api.graphql.GraphQLDesc
import com.expediagroup.graphql.generator.annotations.GraphQLDescription

data class ProductInventory(
    @GraphQLDescription(GraphQLDesc.Product.Inventory.onePreOrder) var onePreOrder: Boolean,
    @GraphQLDescription(GraphQLDesc.Product.Inventory.trackInventory) var trackInventory: Boolean = true,
    @GraphQLDescription(GraphQLDesc.Product.Inventory.remainingStock) var remainingStock: Int,
    @GraphQLDescription(GraphQLDesc.Product.Inventory.stockStatus) var stockStatus: StockStatus = if (remainingStock > 0) StockStatus.IN_STOCK else StockStatus.OUT_OF_STOCK,
    @GraphQLDescription(GraphQLDesc.Product.Inventory.backorderStatus) var backorderStatus: BackorderStatus = BackorderStatus.ALLOWED,
    @GraphQLDescription(GraphQLDesc.Product.Inventory.canBackorder) var canBackorder: Boolean = true,
    @GraphQLDescription(GraphQLDesc.Product.Inventory.isOnBackorder) var isOnBackorder: Boolean = false,
    @GraphQLDescription(GraphQLDesc.Product.Inventory.lowStockThreshold) var lowStockThreshold: Int = 10,
)
