package com.digitaldesigns.shoppe.api.features.currency

import com.digitaldesigns.shoppe.api.domain.models.Model
import com.digitaldesigns.shoppe.api.domain.util.generateId
import com.digitaldesigns.shoppe.api.features.order.model.orderDescription
import com.expediagroup.graphql.generator.annotations.GraphQLDescription

@GraphQLDescription(orderDescription)
data class Currency(
    override val id: String = generateId(),
    val name: String,
    val rate: Float,
) : Model {
    fun local(): Currency {
        return Currency(name = "British Pound", rate = 1f)
    }
}
