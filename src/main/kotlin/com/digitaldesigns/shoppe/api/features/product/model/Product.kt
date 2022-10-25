package com.digitaldesigns.shoppe.api.features.product.model

import com.digitaldesigns.shoppe.api.domain.models.Model
import com.digitaldesigns.shoppe.api.domain.models.Page
import com.digitaldesigns.shoppe.api.domain.models.PagingInfo
import com.digitaldesigns.shoppe.api.domain.util.generateId
import com.digitaldesigns.shoppe.api.graphql.GraphQLDesc
import com.expediagroup.graphql.generator.annotations.GraphQLDescription
import io.ktor.util.date.getTimeMillis
import java.util.Collections.emptyList

@GraphQLDescription(GraphQLDesc.Product.model)
data class Product(
    @GraphQLDescription(GraphQLDesc.Product.id) override val id: String = generateId(),
    @GraphQLDescription(GraphQLDesc.Product.userId) val userId: String,
    @GraphQLDescription(GraphQLDesc.Product.shopId) val shopId: String,
    @GraphQLDescription(GraphQLDesc.Product.name) val name: String,
    @GraphQLDescription(GraphQLDesc.Product.slug) val slug: String = "",
    @GraphQLDescription(GraphQLDesc.Product.created) val created: String = getTimeMillis().toString(), // Date
    @GraphQLDescription(GraphQLDesc.Product.modified) var modified: String = "", // Date
    @GraphQLDescription(GraphQLDesc.Product.desc) val desc: String = "",
    @GraphQLDescription(GraphQLDesc.Product.categories) val categories: List<ProductCategory> = emptyList(),
    @GraphQLDescription(GraphQLDesc.Product.tags) val tags: List<ProductTag> = emptyList(),
    @GraphQLDescription(GraphQLDesc.Product.colors) var colors: List<String> = emptyList(),
    @GraphQLDescription(GraphQLDesc.Product.isFeatured) val isFeatured: Boolean = false,
    @GraphQLDescription(GraphQLDesc.Product.totalSales) val totalSales: Int = 0,
    @GraphQLDescription(GraphQLDesc.Product.images) val images: List<ProductImage> = emptyList(),

    @GraphQLDescription(GraphQLDesc.Product.allowReviews) val allowReviews: Boolean = false,
    @GraphQLDescription(GraphQLDesc.Product.averageRating) val averageRating: Double? = null,
    @GraphQLDescription(GraphQLDesc.Product.numRatings) val numRatings: Int = 0,
    @GraphQLDescription(GraphQLDesc.Product.relatedIds) val relatedIds: Boolean = false,
    @GraphQLDescription(GraphQLDesc.Product.attributes) val attributes: List<ProductAttribute> = emptyList(),
    @GraphQLDescription(GraphQLDesc.Product.links) val links: List<String> = emptyList(),

    @GraphQLDescription(GraphQLDesc.Product.productIds) val productIds: List<String> = emptyList(),

    @GraphQLDescription(GraphQLDesc.Product.isVirtual) var isVirtual: Boolean = false,
    @GraphQLDescription(GraphQLDesc.Product.isDownloadable) var isDownloadable: Boolean = false,
    @GraphQLDescription(GraphQLDesc.Product.downloads) var downloads: List<ProductDownload> = emptyList(),
    @GraphQLDescription(GraphQLDesc.Product.downloadLimit) var downloadLimit: Int = 0,
    @GraphQLDescription(GraphQLDesc.Product.daysToDownload) var daysToDownload: Double = 0.0,
    @GraphQLDescription(GraphQLDesc.Product.purchaseNote) var purchaseNote: String = "",

    @GraphQLDescription(GraphQLDesc.Product.onePreOrder) var onePreOrder: Boolean = false,
    @GraphQLDescription(GraphQLDesc.Product.trackInventory) var trackInventory: Boolean = false,
    @GraphQLDescription(GraphQLDesc.Product.remainingStock) var remainingStock: Int = 0,
    @GraphQLDescription(GraphQLDesc.Product.stockStatus) var stockStatus: StockStatus = StockStatus.OUT_OF_STOCK,
    @GraphQLDescription(GraphQLDesc.Product.backorderStatus) var backorderStatus: Boolean = false,
    @GraphQLDescription(GraphQLDesc.Product.canBackorder) var canBackorder: Boolean = false,
    @GraphQLDescription(GraphQLDesc.Product.isOnBackorder) var isOnBackorder: Boolean = false,
    @GraphQLDescription(GraphQLDesc.Product.lowStockThreshold) var lowStockThreshold: Boolean = false,

    @GraphQLDescription(GraphQLDesc.Product.weight) var weight: String = "",
    @GraphQLDescription(GraphQLDesc.Product.weightUnit) var weightUnit: WeightUnit = WeightUnit.G,
    @GraphQLDescription(GraphQLDesc.Product.length) var length: String = "",
    @GraphQLDescription(GraphQLDesc.Product.width) var width: String = "",
    @GraphQLDescription(GraphQLDesc.Product.height) var height: String = "",
    @GraphQLDescription(GraphQLDesc.Product.measureUnit) var measureUnit: MeasureUnit = MeasureUnit.MM,
    @GraphQLDescription(GraphQLDesc.Product.requiresShipping) var requiresShipping: String = "",
    @GraphQLDescription(GraphQLDesc.Product.isShippingTaxable) var isShippingTaxable: String = "",
    @GraphQLDescription(GraphQLDesc.Product.shippingClass) var shippingClass: String = "",
    @GraphQLDescription(GraphQLDesc.Product.shippingClassId) var shippingClassId: String = "",
    @GraphQLDescription(GraphQLDesc.Product.productVariations) val productVariations: List<ProductVariation> = emptyList(),
) : Model

@GraphQLDescription(GraphQLDesc.Product.createInput)
data class ProductCreateInput(
    @GraphQLDescription(GraphQLDesc.Product.name) val name: String,
    @GraphQLDescription(GraphQLDesc.Product.categories) val categories: List<ProductCategory>,
    @GraphQLDescription(GraphQLDesc.Product.images) val images: List<ProductImage>,
    @GraphQLDescription(GraphQLDesc.Product.remainingStock) var remainingStock: Int,
    @GraphQLDescription(GraphQLDesc.Product.price) val price: Double,
    @GraphQLDescription(GraphQLDesc.Product.weight) var weight: String = "",
) {
    fun toModel(userId: String, shopId: String) = Product(
        userId = userId,
        shopId = shopId,
        name = name,
        productVariations = listOf(ProductVariation(price = price)),
    )
}

@GraphQLDescription(productBasicInputDescription)
data class ProductUpdateInput(
    @GraphQLDescription(GraphQLDesc.Product.name) val name: String,
    @GraphQLDescription(GraphQLDesc.Product.categories) val categories: List<ProductCategory>,
    @GraphQLDescription(GraphQLDesc.Product.tags) val tags: List<ProductTag>,
    @GraphQLDescription(GraphQLDesc.Product.isFeatured) val isFeatured: Boolean,
    @GraphQLDescription(GraphQLDesc.Product.allowReviews) val allowReviews: Boolean,
    @GraphQLDescription(GraphQLDesc.Product.relatedIds) val relatedIds: Boolean,
    @GraphQLDescription(GraphQLDesc.Product.attributes) val attributes: List<ProductAttribute>,
    @GraphQLDescription(GraphQLDesc.Product.links) val links: List<String>,
    @GraphQLDescription(GraphQLDesc.Product.images) val images: List<ProductImage>,

    @GraphQLDescription(GraphQLDesc.Product.isVirtual) val isVirtual: Boolean,
    @GraphQLDescription(GraphQLDesc.Product.isDownloadable) val isDownloadable: Boolean,
    @GraphQLDescription(GraphQLDesc.Product.downloads) val downloads: List<ProductDownload>,
    @GraphQLDescription(GraphQLDesc.Product.downloadLimit) val downloadLimit: Int,
    @GraphQLDescription(GraphQLDesc.Product.daysToDownload) val daysToDownload: Double,
    @GraphQLDescription(GraphQLDesc.Product.purchaseNote) val purchaseNote: String,

    @GraphQLDescription(GraphQLDesc.Product.onePreOrder) var onePreOrder: Boolean,
    @GraphQLDescription(GraphQLDesc.Product.trackInventory) var trackInventory: Boolean,
    @GraphQLDescription(GraphQLDesc.Product.remainingStock) var remainingStock: Int,
    @GraphQLDescription(GraphQLDesc.Product.stockStatus) var stockStatus: StockStatus,
    @GraphQLDescription(GraphQLDesc.Product.backorderStatus) var backorderStatus: Boolean,
    @GraphQLDescription(GraphQLDesc.Product.canBackorder) var canBackorder: Boolean,
    @GraphQLDescription(GraphQLDesc.Product.isOnBackorder) var isOnBackorder: Boolean,
    @GraphQLDescription(GraphQLDesc.Product.lowStockThreshold) var lowStockThreshold: Boolean,

    @GraphQLDescription(GraphQLDesc.Product.price) val price: Double,
    @GraphQLDescription(GraphQLDesc.Product.regularPrice) val regularPrice: Double,
    @GraphQLDescription(GraphQLDesc.Product.onSale) val onSale: Boolean,
    @GraphQLDescription(GraphQLDesc.Product.salePrice) val salePrice: Double,
    @GraphQLDescription(GraphQLDesc.Product.saleStart) val saleStart: String,
    @GraphQLDescription(GraphQLDesc.Product.saleEnd) val saleEnd: String,

    @GraphQLDescription(GraphQLDesc.Product.weight) var weight: String,
    @GraphQLDescription(GraphQLDesc.Product.length) var length: String,
    @GraphQLDescription(GraphQLDesc.Product.width) var width: String,
    @GraphQLDescription(GraphQLDesc.Product.height) var height: String,
    @GraphQLDescription(GraphQLDesc.Product.requiresShipping) var requiresShipping: String,
    @GraphQLDescription(GraphQLDesc.Product.isShippingTaxable) var isShippingTaxable: String,
    @GraphQLDescription(GraphQLDesc.Product.shippingClass) var shippingClass: String,
    @GraphQLDescription(GraphQLDesc.Product.shippingClassId) var shippingClassId: String,
) {
    fun toModel(userId: String, shopId: String, productId: String) = Product(
        id = productId,
        userId = userId,
        shopId = shopId,
        name = name,
        categories = categories,
        tags = tags,
        modified = getTimeMillis().toString(),
        isFeatured = isFeatured,
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
        productVariations = listOf(
            ProductVariation(
                price = price,
                regularPrice = regularPrice,
                onSale = onSale,
                salePrice = salePrice,
                saleStart = saleStart,
                saleEnd = saleEnd,
            )
        ),
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
