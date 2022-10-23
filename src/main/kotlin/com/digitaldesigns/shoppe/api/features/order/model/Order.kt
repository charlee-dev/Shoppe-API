package com.digitaldesigns.shoppe.api.features.order.model

import com.digitaldesigns.shoppe.api.domain.models.Model
import com.digitaldesigns.shoppe.api.domain.util.generateId
import com.digitaldesigns.shoppe.api.features.product.model.MeasureUnit
import com.digitaldesigns.shoppe.api.features.product.model.ProductCategory
import com.digitaldesigns.shoppe.api.features.product.model.WeightUnit
import com.digitaldesigns.shoppe.api.features.product.model.categoryDescription
import com.digitaldesigns.shoppe.api.features.product.model.colorsDescription
import com.digitaldesigns.shoppe.api.features.product.model.depthDescription
import com.digitaldesigns.shoppe.api.features.product.model.descriptionDescription
import com.digitaldesigns.shoppe.api.features.product.model.heightDescription
import com.digitaldesigns.shoppe.api.features.product.model.measureDescription
import com.digitaldesigns.shoppe.api.features.product.model.nameDescription
import com.digitaldesigns.shoppe.api.features.product.model.ownerIdDescription
import com.digitaldesigns.shoppe.api.features.product.model.priceDescription
import com.digitaldesigns.shoppe.api.features.product.model.shopIdDescription
import com.digitaldesigns.shoppe.api.features.product.model.weightDescription
import com.digitaldesigns.shoppe.api.features.product.model.weightUnitDescription
import com.digitaldesigns.shoppe.api.features.product.model.widthDescription
import com.digitaldesigns.shoppe.api.features.transaction.Transaction
import com.digitaldesigns.shoppe.api.features.transaction.transactionDescription
import com.digitaldesigns.shoppe.api.features.user.idDescription
import com.expediagroup.graphql.generator.annotations.GraphQLDescription

@GraphQLDescription(orderDescription)
data class Order(
    @GraphQLDescription(orderIdDescription)
    override val id: String = generateId(),
    @GraphQLDescription(buyerIdDescription)
    val buyerId: String,
    @GraphQLDescription(orderItemsDescription)
    val items: List<ProductOrdered>,
    @GraphQLDescription(transactionDescription)
    val transaction: Transaction,
) : Model

const val orderDescription = "placeholder"
const val orderIdDescription = "placeholder"
const val buyerIdDescription = "placeholder"
const val orderItemsDescription = "placeholder"

@GraphQLDescription(orderDescription)
enum class PaymentStatus {
    NOT_PAID, PAID, IN_PROGRESS
}

@GraphQLDescription(productOrderedDescription)
data class ProductOrdered(
    @GraphQLDescription(idDescription)
    override val id: String = generateId(),
    @GraphQLDescription(nameDescription)
    var name: String,
    @GraphQLDescription(descriptionDescription)
    var description: String,
    @GraphQLDescription(ownerIdDescription)
    val userId: String,
    @GraphQLDescription(shopIdDescription)
    val shopId: String,
    @GraphQLDescription(colorsDescription)
    var color: String,
    @GraphQLDescription(categoryDescription)
    var category: ProductCategory,
    @GraphQLDescription(priceDescription)
    var price: Double,
    @GraphQLDescription(widthDescription)
    var width: Double,
    @GraphQLDescription(heightDescription)
    var height: Double,
    @GraphQLDescription(depthDescription)
    var depth: Double,
    @GraphQLDescription(measureDescription)
    var measureUnit: MeasureUnit, // TODO: This will be set by Locale
    @GraphQLDescription(weightDescription)
    var weight: Double,
    @GraphQLDescription(weightUnitDescription)
    var weightUnit: WeightUnit, // TODO: This will be set by Locale
) : Model

const val productOrderedDescription = "placeholder"


