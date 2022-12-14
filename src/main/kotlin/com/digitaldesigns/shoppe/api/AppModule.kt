package com.digitaldesigns.shoppe.api

import com.digitaldesigns.shoppe.api.features.auth.AuthService
import com.digitaldesigns.shoppe.api.features.auth.JwtService
import com.digitaldesigns.shoppe.api.features.order.OrderRepository
import com.digitaldesigns.shoppe.api.features.product.ProductRepository
import com.digitaldesigns.shoppe.api.features.product.ProductService
import com.digitaldesigns.shoppe.api.features.review.ReviewRepository
import com.digitaldesigns.shoppe.api.features.review.ReviewService
import com.digitaldesigns.shoppe.api.features.shop.ShopRepository
import com.digitaldesigns.shoppe.api.features.shop.ShopService
import com.digitaldesigns.shoppe.api.features.user.UserRepository
import com.digitaldesigns.shoppe.api.features.user.UserService
import org.koin.dsl.module
import org.litote.kmongo.KMongo

private val mongoUri: String = System.getenv("MONGO_URI") ?: "mongodb+srv://adrianwitaszak:5b5Q9zAjeWI7KY3o@chore.mcu5tle.mongodb.net/?retryWrites=true&w=majority"

val appModule = module {
    factory { KMongo.createClient(mongoUri) }

    single { UserRepository(get()) }
    single { ShopRepository(get()) }
    single { ProductRepository(get()) }
    single { ReviewRepository(get()) }
    single { OrderRepository(get()) }

    single { JwtService() }
    single { AuthService(get(), get()) }
    single { UserService(get(), get(), get(), get()) }
    single { ProductService(get(), get()) }
    single { ReviewService(get(), get(), get()) }
    single { ShopService(get(), get(), get()) }
}
