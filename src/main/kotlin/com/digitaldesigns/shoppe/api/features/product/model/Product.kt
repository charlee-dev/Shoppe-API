package com.digitaldesigns.shoppe.api.features.product.model

import com.digitaldesigns.shoppe.api.domain.models.Model
import com.digitaldesigns.shoppe.api.domain.models.Page
import com.digitaldesigns.shoppe.api.domain.models.PagingInfo
import com.digitaldesigns.shoppe.api.domain.util.generateId
import com.digitaldesigns.shoppe.api.features.product.model.abstract.ProductCommon
import com.digitaldesigns.shoppe.api.features.product.model.abstract.ProductCrossSell
import com.digitaldesigns.shoppe.api.features.product.model.abstract.ProductDelivery
import com.digitaldesigns.shoppe.api.features.product.model.abstract.ProductGrouped
import com.digitaldesigns.shoppe.api.features.product.model.abstract.ProductInventory
import com.digitaldesigns.shoppe.api.features.product.model.abstract.ProductPrice
import com.digitaldesigns.shoppe.api.features.product.model.abstract.ProductShipping
import com.digitaldesigns.shoppe.api.features.product.model.shared.MeasureUnit
import com.digitaldesigns.shoppe.api.features.product.model.shared.ProductAttribute
import com.digitaldesigns.shoppe.api.features.product.model.shared.ProductCategory
import com.digitaldesigns.shoppe.api.features.product.model.shared.ProductDownload
import com.digitaldesigns.shoppe.api.features.product.model.shared.ProductImage
import com.digitaldesigns.shoppe.api.features.product.model.shared.ProductTag
import com.digitaldesigns.shoppe.api.features.product.model.shared.ProductVariation
import com.digitaldesigns.shoppe.api.features.product.model.shared.WeightUnit
import com.digitaldesigns.shoppe.api.graphql.GraphQLDesc
import com.expediagroup.graphql.generator.annotations.GraphQLDescription
import io.ktor.util.date.getTimeMillis

@GraphQLDescription(GraphQLDesc.Product.model)
data class Product(
    @GraphQLDescription(GraphQLDesc.Product.id) override val id: String = generateId(),
    @GraphQLDescription(GraphQLDesc.Product.userId) val userId: String,
    @GraphQLDescription(GraphQLDesc.Product.shopId) val shopId: String,
    @GraphQLDescription(GraphQLDesc.Product.Common.model) val common: ProductCommon,
    @GraphQLDescription(GraphQLDesc.Product.Price.model) val price: ProductPrice,
    @GraphQLDescription(GraphQLDesc.Product.Inventory.model) val inventory: ProductInventory,
    @GraphQLDescription(GraphQLDesc.Product.Shipping.model) val shipping: ProductShipping,
    @GraphQLDescription(GraphQLDesc.Product.Delivery.model) val delivery: ProductDelivery,
    @GraphQLDescription(GraphQLDesc.Product.CrossSell.model) val crossSell: ProductCrossSell,
    @GraphQLDescription(GraphQLDesc.Product.Grouped.model) val grouped: ProductGrouped,
) : Model

@GraphQLDescription(GraphQLDesc.Product.createInput)
data class ProductCreateInput(
    @GraphQLDescription(GraphQLDesc.Product.Common.name) val name: String,
    @GraphQLDescription(GraphQLDesc.Product.Common.desc) var desc: String,
    @GraphQLDescription(GraphQLDesc.Product.Common.slug) val slug: String,
    @GraphQLDescription(GraphQLDesc.Product.Common.categories) val categories: List<ProductCategory>,
    @GraphQLDescription(GraphQLDesc.Product.Common.tags) val tags: List<ProductTag>,
    @GraphQLDescription(GraphQLDesc.Product.Common.isFeatured) val isFeatured: Boolean,
    @GraphQLDescription(GraphQLDesc.Product.Common.relatedIds) val relatedIds: List<String>,
    @GraphQLDescription(GraphQLDesc.Product.Common.attributes) val attributes: List<ProductAttribute>,
    @GraphQLDescription(GraphQLDesc.Product.Common.links) val links: List<String>,
    @GraphQLDescription(GraphQLDesc.Product.Common.images) val images: List<ProductImage>,
    @GraphQLDescription(GraphQLDesc.Product.Common.productVariations) val productVariations: List<ProductVariation> = emptyList(),
    @GraphQLDescription(GraphQLDesc.Product.Common.colors) val colors: List<String>,
    @GraphQLDescription(GraphQLDesc.Product.Price.price) val price: Double,
    @GraphQLDescription(GraphQLDesc.Product.Inventory.onePreOrder) var onePreOrder: Boolean,
    @GraphQLDescription(GraphQLDesc.Product.Inventory.remainingStock) var remainingStock: Int,
    @GraphQLDescription(GraphQLDesc.Product.Shipping.weight) var weight: String,
    @GraphQLDescription(GraphQLDesc.Product.Shipping.weightUnit) var weightUnit: WeightUnit,
    @GraphQLDescription(GraphQLDesc.Product.Shipping.length) var length: String,
    @GraphQLDescription(GraphQLDesc.Product.Shipping.width) var width: String,
    @GraphQLDescription(GraphQLDesc.Product.Shipping.height) var height: String,
    @GraphQLDescription(GraphQLDesc.Product.Shipping.measureUnit) var measureUnit: MeasureUnit,
    @GraphQLDescription(GraphQLDesc.Product.Shipping.requiresShipping) var requiresShipping: String,
    @GraphQLDescription(GraphQLDesc.Product.Shipping.isShippingTaxable) var isShippingTaxable: String,
    @GraphQLDescription(GraphQLDesc.Product.Shipping.shippingClass) var shippingClass: String,
    @GraphQLDescription(GraphQLDesc.Product.Shipping.shippingClassId) var shippingClassId: String,
    @GraphQLDescription(GraphQLDesc.Product.Delivery.isVirtual) val isVirtual: Boolean,
    @GraphQLDescription(GraphQLDesc.Product.Delivery.isDownloadable) val isDownloadable: Boolean,
    @GraphQLDescription(GraphQLDesc.Product.Delivery.downloads) val downloads: List<ProductDownload>,
    @GraphQLDescription(GraphQLDesc.Product.Delivery.downloadLimit) val downloadLimit: Int,
    @GraphQLDescription(GraphQLDesc.Product.Delivery.daysToDownload) val daysToDownload: Double,
    @GraphQLDescription(GraphQLDesc.Product.Delivery.purchaseNote) val purchaseNote: String,
    @GraphQLDescription(GraphQLDesc.Product.CrossSell.productIds) val productIds: List<String>,
) {
    fun toModel(userId: String, shopId: String) = Product(
        userId = userId,
        shopId = shopId,
        common = ProductCommon(
            name = name,
            desc = desc,
            slug = slug,
            categories = categories,
            tags = tags,
            isFeatured = isFeatured,
            relatedIds = relatedIds,
            attributes = attributes,
            links = links,
            images = images,
            productVariations = productVariations,
            colors = colors,
        ),
        price = ProductPrice(price = price),
        inventory = ProductInventory(
            onePreOrder = onePreOrder,
            remainingStock = remainingStock,
        ),
        shipping = ProductShipping(
            weight = weight,
            weightUnit = weightUnit,
            length = length,
            width = width,
            height = height,
            measureUnit = measureUnit,
            requiresShipping = requiresShipping,
            isShippingTaxable = isShippingTaxable,
            shippingClass = shippingClass,
            shippingClassId = shippingClassId,
        ),
        delivery = ProductDelivery(
            isVirtual = isVirtual,
            isDownloadable = isDownloadable,
            downloads = downloads,
            downloadLimit = downloadLimit,
            daysToDownload = daysToDownload,
            purchaseNote = purchaseNote,
        ),
        crossSell = ProductCrossSell(productIds = productIds),
        grouped = ProductGrouped(productIds = productIds),
    )
}

@GraphQLDescription(GraphQLDesc.Product.updateInput)
data class ProductUpdateInput(
    @GraphQLDescription(GraphQLDesc.Product.id) override val id: String,
    @GraphQLDescription(GraphQLDesc.Product.Common.name) val name: String,
    @GraphQLDescription(GraphQLDesc.Product.Common.desc) var desc: String,
    @GraphQLDescription(GraphQLDesc.Product.Common.slug) val slug: String,
    @GraphQLDescription(GraphQLDesc.Product.Common.categories) val categories: List<ProductCategory>,
    @GraphQLDescription(GraphQLDesc.Product.Common.tags) val tags: List<ProductTag>,
    @GraphQLDescription(GraphQLDesc.Product.Common.isFeatured) val isFeatured: Boolean,
    @GraphQLDescription(GraphQLDesc.Product.Common.relatedIds) val relatedIds: List<String>,
    @GraphQLDescription(GraphQLDesc.Product.Common.attributes) val attributes: List<ProductAttribute>,
    @GraphQLDescription(GraphQLDesc.Product.Common.links) val links: List<String>,
    @GraphQLDescription(GraphQLDesc.Product.Common.images) val images: List<ProductImage>,
    @GraphQLDescription(GraphQLDesc.Product.Common.productVariations) val productVariations: List<ProductVariation> = emptyList(),
    @GraphQLDescription(GraphQLDesc.Product.Common.colors) val colors: List<String>,
    @GraphQLDescription(GraphQLDesc.Product.Price.price) val price: Double,
    @GraphQLDescription(GraphQLDesc.Product.Inventory.onePreOrder) var onePreOrder: Boolean,
    @GraphQLDescription(GraphQLDesc.Product.Inventory.remainingStock) var remainingStock: Int,
    @GraphQLDescription(GraphQLDesc.Product.Shipping.weight) var weight: String,
    @GraphQLDescription(GraphQLDesc.Product.Shipping.weightUnit) var weightUnit: WeightUnit,
    @GraphQLDescription(GraphQLDesc.Product.Shipping.length) var length: String,
    @GraphQLDescription(GraphQLDesc.Product.Shipping.width) var width: String,
    @GraphQLDescription(GraphQLDesc.Product.Shipping.height) var height: String,
    @GraphQLDescription(GraphQLDesc.Product.Shipping.measureUnit) var measureUnit: MeasureUnit,
    @GraphQLDescription(GraphQLDesc.Product.Shipping.requiresShipping) var requiresShipping: String,
    @GraphQLDescription(GraphQLDesc.Product.Shipping.isShippingTaxable) var isShippingTaxable: String,
    @GraphQLDescription(GraphQLDesc.Product.Shipping.shippingClass) var shippingClass: String,
    @GraphQLDescription(GraphQLDesc.Product.Shipping.shippingClassId) var shippingClassId: String,
    @GraphQLDescription(GraphQLDesc.Product.Delivery.isVirtual) val isVirtual: Boolean,
    @GraphQLDescription(GraphQLDesc.Product.Delivery.isDownloadable) val isDownloadable: Boolean,
    @GraphQLDescription(GraphQLDesc.Product.Delivery.downloads) val downloads: List<ProductDownload>,
    @GraphQLDescription(GraphQLDesc.Product.Delivery.downloadLimit) val downloadLimit: Int,
    @GraphQLDescription(GraphQLDesc.Product.Delivery.daysToDownload) val daysToDownload: Double,
    @GraphQLDescription(GraphQLDesc.Product.Delivery.purchaseNote) val purchaseNote: String,
    @GraphQLDescription(GraphQLDesc.Product.CrossSell.productIds) val productIds: List<String>,
) : Model {
    fun toModel(userId: String, shopId: String, productId: String) = Product(
        id = productId,
        userId = userId,
        shopId = shopId,
        common = ProductCommon(
            name = name,
            desc = desc,
            slug = slug,
            modified = getTimeMillis().toString(),
            categories = categories,
            tags = tags,
            isFeatured = isFeatured,
            relatedIds = relatedIds,
            attributes = attributes,
            links = links,
            images = images,
            productVariations = productVariations,
            colors = colors,
        ),
        price = ProductPrice(price = price),
        inventory = ProductInventory(
            onePreOrder = onePreOrder,
            remainingStock = remainingStock,
        ),
        shipping = ProductShipping(
            weight = weight,
            weightUnit = weightUnit,
            length = length,
            width = width,
            height = height,
            measureUnit = measureUnit,
            requiresShipping = requiresShipping,
            isShippingTaxable = isShippingTaxable,
            shippingClass = shippingClass,
            shippingClassId = shippingClassId,
        ),
        delivery = ProductDelivery(
            isVirtual = isVirtual,
            isDownloadable = isDownloadable,
            downloads = downloads,
            downloadLimit = downloadLimit,
            daysToDownload = daysToDownload,
            purchaseNote = purchaseNote,
        ),
        crossSell = ProductCrossSell(productIds = productIds),
        grouped = ProductGrouped(productIds = productIds),
    )
}

@GraphQLDescription(GraphQLDesc.Product.Page.model)
data class ProductPage(
    @GraphQLDescription(GraphQLDesc.Product.Page.results)
    val results: List<Product>,
    @GraphQLDescription(GraphQLDesc.Product.Page.info)
    val info: PagingInfo,
)

fun Page<Product>.toProductPage() = ProductPage(
    results = results,
    info = info
)
