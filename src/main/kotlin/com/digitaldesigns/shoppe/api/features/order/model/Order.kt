package com.digitaldesigns.shoppe.api.features.order.model

import com.digitaldesigns.shoppe.api.domain.models.Model
import com.digitaldesigns.shoppe.api.domain.util.generateId
import com.digitaldesigns.shoppe.api.graphql.GraphQLDesc
import com.expediagroup.graphql.generator.annotations.GraphQLDescription

@GraphQLDescription(GraphQLDesc.Order.model)
data class Order(
    @GraphQLDescription(GraphQLDesc.Order.parentId)
    override val id: String = generateId(),
    @GraphQLDescription(GraphQLDesc.Order.userId)
    val userId: String,
    @GraphQLDescription(GraphQLDesc.Order.status)
    val status: OrderStatus,
    @GraphQLDescription(GraphQLDesc.Order.currency)
    val currency: String,
    @GraphQLDescription(GraphQLDesc.Order.version)
    val version: String,
    @GraphQLDescription(GraphQLDesc.Order.pricesIncludeTax)
    val pricesIncludeTax: Double,
    @GraphQLDescription(GraphQLDesc.Order.discountTotal)
    val discountTotal: Double,
    @GraphQLDescription(GraphQLDesc.Order.discountTax)
    val discountTax: Double,
    @GraphQLDescription(GraphQLDesc.Order.shippingTotal)
    val shippingTotal: Double,
    @GraphQLDescription(GraphQLDesc.Order.shippingTax)
    val shippingTax: Double,
    @GraphQLDescription(GraphQLDesc.Order.cartTax)
    val cartTax: Double,
    @GraphQLDescription(GraphQLDesc.Order.total)
    val total: Double,
    @GraphQLDescription(GraphQLDesc.Order.totalTax)
    val totalTax: Double,
    @GraphQLDescription(GraphQLDesc.Order.customerId)
    val customerId: String,
    @GraphQLDescription(GraphQLDesc.Order.billing)
    val billing: BillingOrderAddress,
    @GraphQLDescription(GraphQLDesc.Order.shipping)
    val shipping: ShippingOrderAddress,
    @GraphQLDescription(GraphQLDesc.Order.paymentMethod)
    val paymentMethod: String,
    @GraphQLDescription(GraphQLDesc.Order.transactionId)
    val transactionId: String,
    @GraphQLDescription(GraphQLDesc.Order.customerIpAddress)
    val customerIpAddress: String,
    @GraphQLDescription(GraphQLDesc.Order.customerNote)
    val customerNote: String,
    @GraphQLDescription(GraphQLDesc.Order.dateCompleted)
    val dateCompleted: String, // DATE
    @GraphQLDescription(GraphQLDesc.Order.datePaid)
    val datePaid: String, // DATE
    @GraphQLDescription(GraphQLDesc.Order.orderNumber)
    val orderNumber: String,
    @GraphQLDescription(GraphQLDesc.Order.currencySymbol)
    val currencySymbol: String,
    @GraphQLDescription(GraphQLDesc.Order.setPaid)
    val setPaid: Boolean,
    @GraphQLDescription(GraphQLDesc.Order.lineItems)
    val lineItems: List<OrderLineItem>,
    @GraphQLDescription(GraphQLDesc.Order.taxLines)
    val taxLines: List<OrderTaxRate>,
    @GraphQLDescription(GraphQLDesc.Order.shippingLines)
    val shippingLines: List<OrderShippingLine>,
    @GraphQLDescription(GraphQLDesc.Order.feeLines)
    val feeLines: List<OrderFeeLine>,
    @GraphQLDescription(GraphQLDesc.Order.couponLines)
    val couponLines: List<OrderCouponLine>,
    @GraphQLDescription(GraphQLDesc.Order.refunds)
    val refunds: List<OrderRefundLine>,
) : Model

@GraphQLDescription(GraphQLDesc.Order.createInput)
data class OrderCreateInput(
    @GraphQLDescription(GraphQLDesc.Order.status) val status: OrderStatus,
    @GraphQLDescription(GraphQLDesc.Order.currency) val currency: String,
    @GraphQLDescription(GraphQLDesc.Order.version) val version: String,
    @GraphQLDescription(GraphQLDesc.Order.pricesIncludeTax) val pricesIncludeTax: Double,
    @GraphQLDescription(GraphQLDesc.Order.discountTotal) val discountTotal: Double,
    @GraphQLDescription(GraphQLDesc.Order.discountTax) val discountTax: Double,
    @GraphQLDescription(GraphQLDesc.Order.shippingTotal) val shippingTotal: Double,
    @GraphQLDescription(GraphQLDesc.Order.shippingTax) val shippingTax: Double,
    @GraphQLDescription(GraphQLDesc.Order.cartTax) val cartTax: Double,
    @GraphQLDescription(GraphQLDesc.Order.total) val total: Double,
    @GraphQLDescription(GraphQLDesc.Order.totalTax) val totalTax: Double,
    @GraphQLDescription(GraphQLDesc.Order.customerId) val customerId: String,
    @GraphQLDescription(GraphQLDesc.Order.billing) val billing: BillingOrderAddress,
    @GraphQLDescription(GraphQLDesc.Order.shipping) val shipping: ShippingOrderAddress,
    @GraphQLDescription(GraphQLDesc.Order.paymentMethod) val paymentMethod: String,
    @GraphQLDescription(GraphQLDesc.Order.transactionId) val transactionId: String,
    @GraphQLDescription(GraphQLDesc.Order.customerIpAddress) val customerIpAddress: String,
    @GraphQLDescription(GraphQLDesc.Order.customerNote) val customerNote: String,
    @GraphQLDescription(GraphQLDesc.Order.dateCompleted) val dateCompleted: String, // DATE
    @GraphQLDescription(GraphQLDesc.Order.datePaid) val datePaid: String, // DATE
    @GraphQLDescription(GraphQLDesc.Order.orderNumber) val orderNumber: String,
    @GraphQLDescription(GraphQLDesc.Order.currencySymbol) val currencySymbol: String,
    @GraphQLDescription(GraphQLDesc.Order.setPaid) val setPaid: Boolean,
    @GraphQLDescription(GraphQLDesc.Order.lineItems) val lineItems: List<OrderLineItem>,
    @GraphQLDescription(GraphQLDesc.Order.taxLines) val taxLines: List<OrderTaxRate>,
    @GraphQLDescription(GraphQLDesc.Order.shippingLines) val shippingLines: List<OrderShippingLine>,
    @GraphQLDescription(GraphQLDesc.Order.feeLines) val feeLines: List<OrderFeeLine>,
    @GraphQLDescription(GraphQLDesc.Order.couponLines) val couponLines: List<OrderCouponLine>,
    @GraphQLDescription(GraphQLDesc.Order.refunds) val refunds: List<OrderRefundLine>,
) {
    fun toModel(userId: String) = Order(
        userId = userId,
        status = status,
        currency = currency,
        version = version,
        pricesIncludeTax = pricesIncludeTax,
        discountTotal = discountTotal,
        discountTax = discountTax,
        shippingTotal = shippingTotal,
        shippingTax = shippingTax,
        cartTax = cartTax,
        total = total,
        totalTax = totalTax,
        customerId = customerId,
        billing = billing,
        shipping = shipping,
        paymentMethod = paymentMethod,
        transactionId = transactionId,
        customerIpAddress = customerIpAddress,
        customerNote = customerNote,
        dateCompleted = dateCompleted,
        datePaid = datePaid,
        orderNumber = orderNumber,
        currencySymbol = currencySymbol,
        setPaid = setPaid,
        lineItems = lineItems,
        taxLines = taxLines,
        shippingLines = shippingLines,
        feeLines = feeLines,
        couponLines = couponLines,
        refunds = refunds,
    )
}
