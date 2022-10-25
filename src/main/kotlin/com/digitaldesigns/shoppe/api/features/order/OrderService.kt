package com.digitaldesigns.shoppe.api.features.order

import com.digitaldesigns.shoppe.api.domain.util.checkPermissions
import com.digitaldesigns.shoppe.api.features.order.model.Order
import com.digitaldesigns.shoppe.api.features.order.model.OrderCreateInput

class OrderService(
    private val orderRepository: OrderRepository,
) {
    fun createOrder(userId: String, orderCreateInput: OrderCreateInput): Order {
        return orderRepository.add(orderCreateInput.toModel(userId))
    }

    fun deleteOrder(userId: String, orderId: String): Boolean {
        val order = orderRepository.getById(orderId)
        return checkPermissions(order.userId, userId) {
            orderRepository.delete(orderId)
        }
    }
}
