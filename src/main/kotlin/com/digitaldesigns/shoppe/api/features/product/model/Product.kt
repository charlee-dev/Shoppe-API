package com.digitaldesigns.shoppe.api.features.product.model

import com.digitaldesigns.shoppe.api.domain.models.Identifiable
import com.digitaldesigns.shoppe.api.domain.models.Page
import com.digitaldesigns.shoppe.api.domain.models.PagingInfo
import com.digitaldesigns.shoppe.api.domain.util.generateId
import com.digitaldesigns.shoppe.api.features.user.idDescription
import com.expediagroup.graphql.generator.annotations.GraphQLDescription
import io.ktor.util.date.getTimeMillis
import java.util.Collections.emptyList

@GraphQLDescription(productDescription)
data class Product(
    @GraphQLDescription(idDescription)
    override val id: String = generateId(),
    @GraphQLDescription(nameDescription)
    var name: String,
    @GraphQLDescription(descriptionDescription)
    var description: String = "",
    @GraphQLDescription(ownerIdDescription)
    val userId: String,
    @GraphQLDescription(shopIdDescription)
    val shopId: String,
    @GraphQLDescription(imagesDescription)
    var images: List<String> = emptyList(),
    @GraphQLDescription(colorsDescription)
    var colors: List<String> = emptyList(), // First color is a primary color
    @GraphQLDescription(categoryDescription)
    var category: Category = Category.DEFAULT,
    @GraphQLDescription(ratingDescription)
    var rating: Double? = null,
    @GraphQLDescription(priceDescription)
    var price: Double,
    @GraphQLDescription(isOnSaleDescription)
    var isOnSale: Boolean = false,
    @GraphQLDescription(salePriceDescription)
    var salePrice: Double? = null,
    @GraphQLDescription(saleEndsDateDescription)
    var saleEndsDate: String? = null,
    @GraphQLDescription(widthDescription)
    var width: Double? = null,
    @GraphQLDescription(heightDescription)
    var height: Double? = null,
    @GraphQLDescription(depthDescription)
    var depth: Double? = null,
    @GraphQLDescription(measureDescription)
    var measureUnit: MeasureUnit = MeasureUnit.MM, // TODO: This will be set by Locale
    @GraphQLDescription(weightDescription)
    var weight: Double? = null,
    @GraphQLDescription(weightUnitDescription)
    var weightUnit: WeightUnit = WeightUnit.G, // TODO: This will be set by Locale
    @GraphQLDescription(createdDateDescription)
    var dateCreated: String = getTimeMillis().toString(),
) : Identifiable

enum class MeasureUnit {
    MM, CM, M, INCH, FOOT
}

enum class WeightUnit {
    G, KG, STONE, POUND, LBS
}

@GraphQLDescription(productBasicInputDescription)
data class ProductBasicInput(
    val name: String,
    val description: String = "",
    val images: List<String> = emptyList(),
    val category: Category = Category.DEFAULT,
    val price: Double,
) {
    fun toModel(userId: String, shopId: String) = Product(
        name = name,
        description = description,
        userId = userId,
        shopId = shopId,
        images = images,
        category = category,
        price = price
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

@GraphQLDescription(productUpdateInputDescription)
data class ProductUpdateInput(
    var name: String,
    var description: String = "",
    var images: List<String> = emptyList(),
    var category: Category = Category.DEFAULT,
    var price: Double,
) {
    fun toModel(userId: String, productId: String, shopId: String) = Product(
        id = productId,
        name = name,
        description = description,
        userId = userId,
        shopId = shopId,
        images = images,
        category = category,
        price = price
    )
}

const val productDescription = "Model of the product"
const val nameDescription = "Model of the product"
const val descriptionDescription = "Model of the product"
const val ownerIdDescription = "Model of the product"
const val imagesDescription = "Model of the product"
const val colorsDescription = "Model of the product"
const val categoryDescription = "Model of the product"
const val ratingDescription = "Model of the product"
const val priceDescription = "Model of the product"
const val isOnSaleDescription = "Model of the product"
const val salePriceDescription = "Model of the product"
const val saleEndsDateDescription = "Model of the product"
const val createdDateDescription = "Model of the product"
const val weightDescription = "Model of the product"
const val weightUnitDescription = "Model of the product"
const val productBasicInputDescription = "Provide parameters just to create simple Product model"
const val productUpdateInputDescription = "Provide parameters just to create simple Product model"
const val widthDescription = "Model of the product"
const val heightDescription = "Model of the product"
const val depthDescription = "Model of the product"
const val measureDescription = "Model of the product"
const val productPageDescription = "Model of the product"
const val shopIdDescription = "Model of the product"
