package com.digitaldesigns.shoppe.api.features.transaction

import com.digitaldesigns.shoppe.api.domain.models.Model
import com.digitaldesigns.shoppe.api.domain.util.generateId
import com.digitaldesigns.shoppe.api.features.currency.Currency
import com.digitaldesigns.shoppe.api.features.order.model.PaymentStatus
import com.digitaldesigns.shoppe.api.features.user.idDescription
import com.expediagroup.graphql.generator.annotations.GraphQLDescription

@GraphQLDescription(transactionDescription)
data class Transaction(
    @GraphQLDescription(idDescription)
    override val id: String = generateId(),
    @GraphQLDescription(transactionAmountDescription)
    val amount: Double,
    @GraphQLDescription(transactionTaxDescription)
    val tax: Double,
    @GraphQLDescription(transactionCurrencyDescription)
    val currency: Currency,
    @GraphQLDescription(transactionStatusDescription)
    val status: PaymentStatus = PaymentStatus.NOT_PAID,
) : Model

const val transactionDescription = "placeholder"
const val transactionAmountDescription = "placeholder"
const val transactionTaxDescription = "placeholder"
const val transactionCurrencyDescription = "placeholder"
const val transactionStatusDescription = "placeholder"
