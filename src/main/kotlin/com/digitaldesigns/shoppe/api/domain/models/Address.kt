package com.digitaldesigns.shoppe.api.domain.models

interface Address {
    val firstName: String
    val lastName: String
    val company: String
    val address1: String
    val address2: String
    val city: String
    val state: String
    val postCode: String
    val country: String
}
