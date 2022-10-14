package com.digitaldesigns.shoppe.api

import com.digitaldesigns.shoppe.api.features.auth.AuthService
import com.digitaldesigns.shoppe.api.features.auth.JwtService
import com.digitaldesigns.shoppe.api.features.product.ProductRepository
import com.digitaldesigns.shoppe.api.features.product.ProductService
import com.digitaldesigns.shoppe.api.features.review.ReviewRepository
import com.digitaldesigns.shoppe.api.features.review.ReviewService
import com.digitaldesigns.shoppe.api.features.shop.ShopRepository
import com.digitaldesigns.shoppe.api.features.shop.ShopService
import com.digitaldesigns.shoppe.api.features.user.UserRepository
import com.digitaldesigns.shoppe.api.features.user.UserService
import com.digitaldesigns.shoppe.api.graphql.ShoppeConfig
import org.koin.dsl.module
import org.litote.kmongo.KMongo

val appModule = module() {
    factory { KMongo.createClient(ShoppeConfig.mongoUri) }
    single { UserRepository(get()) }
    single { ProductRepository(get()) }
    single { ReviewRepository(get()) }
    single { ShopRepository(get()) }
    single { JwtService() }
    single { AuthService(get(), get()) }
    single { UserService(get(), get(), get(), get()) }
    single { ProductService(get(), get()) }
    single { ReviewService(get(), get()) }
    single { ShopService(get(), get(), get()) }
}
