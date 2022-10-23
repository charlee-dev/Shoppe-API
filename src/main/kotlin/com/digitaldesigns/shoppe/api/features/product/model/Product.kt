package com.digitaldesigns.shoppe.api.features.product.model

import com.digitaldesigns.shoppe.api.domain.models.Model
import com.digitaldesigns.shoppe.api.domain.models.Page
import com.digitaldesigns.shoppe.api.domain.models.PagingInfo
import com.digitaldesigns.shoppe.api.domain.models.TimeTrackable
import com.digitaldesigns.shoppe.api.domain.util.generateId
import com.digitaldesigns.shoppe.api.features.product.model.classes.ProductAttribute
import com.digitaldesigns.shoppe.api.graphql.GraphQLDesc
import com.expediagroup.graphql.generator.annotations.GraphQLDescription
import io.ktor.util.date.getTimeMillis
import java.util.Collections.emptyList

@GraphQLDescription(GraphQLDesc.Product.Common.model)
data class Product(
    @GraphQLDescription(GraphQLDesc.Product.Common.id) override val id: String = generateId(),
    @GraphQLDescription(GraphQLDesc.Product.Common.userId) val userId: String,
    @GraphQLDescription(GraphQLDesc.Product.Common.shopId) val shopId: String,
    @GraphQLDescription(GraphQLDesc.Product.Common.name) val name: String,
    @GraphQLDescription(GraphQLDesc.Product.Common.slug) val slug: String = "",
    @GraphQLDescription(GraphQLDesc.Product.Common.created) val created: String = getTimeMillis().toString(), // Date
    @GraphQLDescription(GraphQLDesc.Product.Common.modified) var modified: String = "", // Date
    @GraphQLDescription(GraphQLDesc.Product.Common.desc) val desc: String = "",
    @GraphQLDescription(GraphQLDesc.Product.Common.categories) val categories: List<ProductCategory> = emptyList(),
    @GraphQLDescription(GraphQLDesc.Product.Common.tags) val tags: List<ProductTag> = emptyList(),
    @GraphQLDescription(GraphQLDesc.Product.Common.catalogVisibility) val catalogVisibility: CatalogVisibility = CatalogVisibility.EVERYWHERE,
    @GraphQLDescription(GraphQLDesc.Product.Common.colors) var colors: List<String> = emptyList(),
    @GraphQLDescription(GraphQLDesc.Product.Common.isFeatured) val isFeatured: Boolean = false,
    @GraphQLDescription(GraphQLDesc.Product.Common.totalSales) val totalSales: Int = 0,
    @GraphQLDescription(GraphQLDesc.Product.Common.images) val images: List<ProductImage> = emptyList(),

    @GraphQLDescription(GraphQLDesc.Product.Common.allowReviews) val allowReviews: Boolean = false,
    @GraphQLDescription(GraphQLDesc.Product.Common.averageRating) val averageRating: Boolean = false,
    @GraphQLDescription(GraphQLDesc.Product.Common.numRatings) val numRatings: Boolean = false,
    @GraphQLDescription(GraphQLDesc.Product.Common.relatedIds) val relatedIds: Boolean = false,
    @GraphQLDescription(GraphQLDesc.Product.Common.attributes) val attributes: List<ProductAttribute> = emptyList(),
    @GraphQLDescription(GraphQLDesc.Product.Common.links) val links: Boolean = false,

    @GraphQLDescription(GraphQLDesc.Product.CrossSells.productIds) val productIds: List<String> = emptyList(),

    @GraphQLDescription(GraphQLDesc.Product.Delivery.isVirtual) var isVirtual: Boolean = false,
    @GraphQLDescription(GraphQLDesc.Product.Delivery.isDownloadable) var isDownloadable: Boolean = false,
    @GraphQLDescription(GraphQLDesc.Product.Delivery.downloads) var downloads: List<ProductDownload> = emptyList(),
    @GraphQLDescription(GraphQLDesc.Product.Delivery.downloadLimit) var downloadLimit: Int = 0,
    @GraphQLDescription(GraphQLDesc.Product.Delivery.daysToDownload) var daysToDownload: Double = 0.0,
    @GraphQLDescription(GraphQLDesc.Product.Delivery.purchaseNote) var purchaseNote: String = "",

    @GraphQLDescription(GraphQLDesc.Product.Inventory.onePreOrder) var onePreOrder: Boolean = false,
    @GraphQLDescription(GraphQLDesc.Product.Inventory.trackInventory) var trackInventory: Boolean = false,
    @GraphQLDescription(GraphQLDesc.Product.Inventory.remainingStock) var remainingStock: Int = 0,
    @GraphQLDescription(GraphQLDesc.Product.Inventory.stockStatus) var stockStatus: StockStatus = StockStatus.OUT_OF_STOCK,
    @GraphQLDescription(GraphQLDesc.Product.Inventory.backorderStatus) var backorderStatus: Boolean = false,
    @GraphQLDescription(GraphQLDesc.Product.Inventory.canBackorder) var canBackorder: Boolean = false,
    @GraphQLDescription(GraphQLDesc.Product.Inventory.isOnBackorder) var isOnBackorder: Boolean = false,
    @GraphQLDescription(GraphQLDesc.Product.Inventory.lowStockThreshold) var lowStockThreshold: Boolean = false,

    @GraphQLDescription(GraphQLDesc.Product.Price.price) var price: Double,
    @GraphQLDescription(GraphQLDesc.Product.Price.regularPrice) var regularPrice: Double = price,
    @GraphQLDescription(GraphQLDesc.Product.Price.onSale) var onSale: Boolean = false,
    @GraphQLDescription(GraphQLDesc.Product.Price.salePrice) var salePrice: Double = price,
    @GraphQLDescription(GraphQLDesc.Product.Price.saleStart) var saleStart: String = "", // Date
    @GraphQLDescription(GraphQLDesc.Product.Price.saleEnd) var saleEnd: String = "", // Date

    @GraphQLDescription(GraphQLDesc.Product.Shipping.weight) var weight: String = "",
    @GraphQLDescription(GraphQLDesc.Product.Shipping.weightUnit) var weightUnit: WeightUnit = WeightUnit.G,
    @GraphQLDescription(GraphQLDesc.Product.Shipping.length) var length: String = "",
    @GraphQLDescription(GraphQLDesc.Product.Shipping.width) var width: String = "",
    @GraphQLDescription(GraphQLDesc.Product.Shipping.height) var height: String = "",
    @GraphQLDescription(GraphQLDesc.Product.Shipping.measureUnit) var measureUnit: MeasureUnit = MeasureUnit.MM,
    @GraphQLDescription(GraphQLDesc.Product.Shipping.requiresShipping) var requiresShipping: String = "",
    @GraphQLDescription(GraphQLDesc.Product.Shipping.isShippingTaxable) var isShippingTaxable: String = "",
    @GraphQLDescription(GraphQLDesc.Product.Shipping.shippingClass) var shippingClass: String = "",
    @GraphQLDescription(GraphQLDesc.Product.Shipping.shippingClassId) var shippingClassId: String = "",
) : Model

@GraphQLDescription(GraphQLDesc.Product.Tag.model)
data class ProductCategory(
    @GraphQLDescription(GraphQLDesc.Product.Category.name)
    var name: String,
    @GraphQLDescription(GraphQLDesc.Product.Category.isCustom)
    var isCustom: Boolean = true,
    @GraphQLDescription(GraphQLDesc.Product.Category.createdDate)
    val createdDate: String = getTimeMillis().toString(), // Date
    @GraphQLDescription(GraphQLDesc.Product.Category.createdBy)
    val createdBy: String,
)

@GraphQLDescription(GraphQLDesc.Product.Download.model)
data class ProductDownload(
    @GraphQLDescription(GraphQLDesc.Product.Download.id)
    override val id: String = generateId(),
    @GraphQLDescription(GraphQLDesc.Product.Download.name)
    var name: String,
    @GraphQLDescription(GraphQLDesc.Product.Download.url)
    var url: String,
) : Model

@GraphQLDescription(GraphQLDesc.Product.Tag.model)
data class ProductTag(
    @GraphQLDescription(GraphQLDesc.Product.Tag.name)
    var name: String,
    @GraphQLDescription(GraphQLDesc.Product.Tag.isCustom)
    var isCustom: Boolean,
    @GraphQLDescription(GraphQLDesc.Product.Tag.createdDate)
    val createdDate: String = getTimeMillis().toString(), // Date
    @GraphQLDescription(GraphQLDesc.Product.Tag.createdBy)
    val createdBy: String,
)

@GraphQLDescription(GraphQLDesc.Product.Image.model)
data class ProductImage(
    @GraphQLDescription(GraphQLDesc.Product.Image.id)
    override val id: String = generateId(),
    @GraphQLDescription(GraphQLDesc.Product.Image.created)
    override val created: String = "",
    @GraphQLDescription(GraphQLDesc.Product.Image.modified)
    override var modified: String = "",
    @GraphQLDescription(GraphQLDesc.Product.Image.url)
    var url: String = "",
    @GraphQLDescription(GraphQLDesc.Product.Image.name)
    var name: String = "",
    @GraphQLDescription(GraphQLDesc.Product.Image.altText)
    var altText: String = "",
) : Model, TimeTrackable

@GraphQLDescription(productBasicInputDescription)
data class ProductCreateInput(
    @GraphQLDescription(GraphQLDesc.Product.Common.name) val name: String,
    @GraphQLDescription(GraphQLDesc.Product.Common.categories) val categories: List<ProductCategory>,
    @GraphQLDescription(GraphQLDesc.Product.Common.images) val images: List<ProductImage>,
    @GraphQLDescription(GraphQLDesc.Product.Inventory.remainingStock) var remainingStock: Int,
    @GraphQLDescription(GraphQLDesc.Product.Price.price) val price: Double,
) {
    fun toModel(userId: String, shopId: String) = Product(
        userId = userId,
        shopId = shopId,
        name = name,
        price = price,
    )
}

@GraphQLDescription(productBasicInputDescription)
data class ProductUpdateInput(
    @GraphQLDescription(GraphQLDesc.Product.Common.name) val name: String,
    @GraphQLDescription(GraphQLDesc.Product.Common.categories) val categories: List<ProductCategory>,
    @GraphQLDescription(GraphQLDesc.Product.Common.tags) val tags: List<ProductTag>,
    @GraphQLDescription(GraphQLDesc.Product.Common.isFeatured) val isFeatured: Boolean,
    @GraphQLDescription(GraphQLDesc.Product.Common.catalogVisibility) val catalogVisibility: CatalogVisibility,
    @GraphQLDescription(GraphQLDesc.Product.Common.allowReviews) val allowReviews: Boolean,
    @GraphQLDescription(GraphQLDesc.Product.Common.relatedIds) val relatedIds: Boolean,
    @GraphQLDescription(GraphQLDesc.Product.Common.attributes) val attributes: List<ProductAttribute>,
    @GraphQLDescription(GraphQLDesc.Product.Common.links) val links: Boolean,
    @GraphQLDescription(GraphQLDesc.Product.Common.images) val images: List<ProductImage>,

    @GraphQLDescription(GraphQLDesc.Product.Delivery.isVirtual) val isVirtual: Boolean,
    @GraphQLDescription(GraphQLDesc.Product.Delivery.isDownloadable) val isDownloadable: Boolean,
    @GraphQLDescription(GraphQLDesc.Product.Delivery.downloads) val downloads: List<ProductDownload>,
    @GraphQLDescription(GraphQLDesc.Product.Delivery.downloadLimit) val downloadLimit: Int,
    @GraphQLDescription(GraphQLDesc.Product.Delivery.daysToDownload) val daysToDownload: Double,
    @GraphQLDescription(GraphQLDesc.Product.Delivery.purchaseNote) val purchaseNote: String,

    @GraphQLDescription(GraphQLDesc.Product.Inventory.onePreOrder) var onePreOrder: Boolean,
    @GraphQLDescription(GraphQLDesc.Product.Inventory.trackInventory) var trackInventory: Boolean,
    @GraphQLDescription(GraphQLDesc.Product.Inventory.remainingStock) var remainingStock: Int,
    @GraphQLDescription(GraphQLDesc.Product.Inventory.stockStatus) var stockStatus: StockStatus,
    @GraphQLDescription(GraphQLDesc.Product.Inventory.backorderStatus) var backorderStatus: Boolean,
    @GraphQLDescription(GraphQLDesc.Product.Inventory.canBackorder) var canBackorder: Boolean,
    @GraphQLDescription(GraphQLDesc.Product.Inventory.isOnBackorder) var isOnBackorder: Boolean,
    @GraphQLDescription(GraphQLDesc.Product.Inventory.lowStockThreshold) var lowStockThreshold: Boolean,

    @GraphQLDescription(GraphQLDesc.Product.Price.price) val price: Double,
    @GraphQLDescription(GraphQLDesc.Product.Price.regularPrice) val regularPrice: Double,
    @GraphQLDescription(GraphQLDesc.Product.Price.onSale) val onSale: Boolean,
    @GraphQLDescription(GraphQLDesc.Product.Price.salePrice) val salePrice: Double,
    @GraphQLDescription(GraphQLDesc.Product.Price.saleStart) val saleStart: String,
    @GraphQLDescription(GraphQLDesc.Product.Price.saleEnd) val saleEnd: String,

    @GraphQLDescription(GraphQLDesc.Product.Shipping.weight) var weight: String,
    @GraphQLDescription(GraphQLDesc.Product.Shipping.length) var length: String,
    @GraphQLDescription(GraphQLDesc.Product.Shipping.width) var width: String,
    @GraphQLDescription(GraphQLDesc.Product.Shipping.height) var height: String,
    @GraphQLDescription(GraphQLDesc.Product.Shipping.requiresShipping) var requiresShipping: String,
    @GraphQLDescription(GraphQLDesc.Product.Shipping.isShippingTaxable) var isShippingTaxable: String,
    @GraphQLDescription(GraphQLDesc.Product.Shipping.shippingClass) var shippingClass: String,
    @GraphQLDescription(GraphQLDesc.Product.Shipping.shippingClassId) var shippingClassId: String,
) {
    fun toModel(userId: String, shopId: String, productId: String) = Product(
        id = productId,
        userId = userId,
        shopId = shopId,
        name = name,
        categories = categories,
        tags = tags,
        isFeatured = isFeatured,
        catalogVisibility = catalogVisibility,
        allowReviews = allowReviews,
        relatedIds = relatedIds,
        attributes = attributes,
        links = links,
        isVirtual = isVirtual,
        isDownloadable = isDownloadable,
        downloads = downloads,
        downloadLimit = downloadLimit,
        daysToDownload = daysToDownload,
        purchaseNote = purchaseNote,
        onePreOrder = onePreOrder,
        trackInventory = trackInventory,
        remainingStock = remainingStock,
        stockStatus = stockStatus,
        backorderStatus = backorderStatus,
        canBackorder = canBackorder,
        isOnBackorder = isOnBackorder,
        lowStockThreshold = lowStockThreshold,
        price = price,
        regularPrice = regularPrice,
        onSale = onSale,
        salePrice = salePrice,
        saleStart = saleStart,
        saleEnd = saleEnd,
        weight = weight,
        length = length,
        width = width,
        height = height,
        requiresShipping = requiresShipping,
        isShippingTaxable = isShippingTaxable,
        shippingClass = shippingClass,
        shippingClassId = shippingClassId,
    )
}

@GraphQLDescription(productPageDescription)
data class ProductPage(
    val results: List<Product>,
    val info: PagingInfo,
)

fun Page<Product>.toProductPage() = ProductPage(
    results = results,
    info = info
)

const val nameDescription = "placeholder"
const val descriptionDescription = "placeholder"
const val ownerIdDescription = "placeholder"
const val colorsDescription = "placeholder"
const val categoryDescription = "placeholder"
const val priceDescription = "placeholder"
const val createdDateDescription = "placeholder"
const val weightDescription = "placeholder"
const val weightUnitDescription = "placeholder"
const val productBasicInputDescription = "placeholder"
const val widthDescription = "placeholder"
const val heightDescription = "placeholder"
const val depthDescription = "placeholder"
const val measureDescription = "placeholder"
const val productPageDescription = "placeholder"
const val shopIdDescription = "placeholder"
