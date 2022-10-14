package com.digitaldesigns.shoppe.api.mock

import com.digitaldesigns.shoppe.api.domain.util.encrypt
import com.digitaldesigns.shoppe.api.features.product.model.Category
import com.digitaldesigns.shoppe.api.features.product.model.Product
import com.digitaldesigns.shoppe.api.features.review.Review
import com.digitaldesigns.shoppe.api.features.shop.Shop
import com.digitaldesigns.shoppe.api.features.user.UserModel

const val password1 = "password1"
const val password2 = "password2"

const val token1 = "token1"
const val token2 = "token2"

val user1 = UserModel(
    "user1id",
    "testEmail1",
    password1.encrypt(),
    "Adrian",
    "image1"
)

val user2 = UserModel(
    "user2id",
    "testEmail2",
    password1.encrypt(),
    "Natalia",
    "image2"
)

val user3 = UserModel(
    "user3id",
    "testEmail3",
    password2.encrypt(),
    "Charlie",
    "image3"
)

val mockUsers = listOf(user1, user2, user3)

val shop1 = Shop(
    id = "1",
    name = "cakeShop",
    description = "descShop",
    ownerId = user1.id,
)

val shop2 = Shop(
    id = "2",
    name = "carShop",
    description = "descShop",
    ownerId = user1.id,
)

val mockShops = listOf(shop1, shop2)

val product1 = Product(
    id = "1",
    name = "cake",
    price = 10.0,
    userId = user1.id,
    colors = listOf("blue"),
    category = Category.CAKE,
    shopId = shop1.id,
)

val product2 = Product(
    id = "2",
    name = "car",
    price = 2000.0,
    userId = user1.id,
    colors = listOf("blue"),
    category = Category.DEFAULT,
    shopId = shop1.id,
)

val product3 = Product(
    id = "3",
    name = "car",
    price = 30.0,
    userId = user2.id,
    colors = listOf("red", "blue"),
    category = Category.DEFAULT,
    shopId = shop1.id,
)

val product4 = Product(
    id = "4",
    name = "red canvas",
    price = 30.0,
    userId = user2.id,
    colors = listOf("red"),
    category = Category.ART,
    shopId = shop1.id,
)

val mockProducts = listOf(product1, product2, product3, product4)

val review1 = Review(
    id = "1",
    authorId = user1.id,
    productId = product1.id,
    text = "review1",
    rating = 5
)

val review2 = Review(
    id = "2",
    authorId = user1.id,
    productId = product1.id,
    text = "review2",
    rating = 3
)

val review3 = Review(
    id = "3",
    authorId = user2.id,
    productId = product2.id,
    text = "review3",
    rating = 3
)

val mockReviews = listOf(review1, review2, review3)
