package com.digitaldesigns.shoppe.api.graphql

import com.digitaldesigns.shoppe.api.features.auth.AuthSchema
import com.digitaldesigns.shoppe.api.features.product.ProductSchema
import com.digitaldesigns.shoppe.api.features.review.ReviewSchema
import com.digitaldesigns.shoppe.api.features.shop.ShopSchema
import com.digitaldesigns.shoppe.api.features.user.UserSchema
import com.expediagroup.graphql.generator.SchemaGeneratorConfig
import com.expediagroup.graphql.generator.TopLevelObject
import com.expediagroup.graphql.generator.scalars.IDValueUnboxer
import com.expediagroup.graphql.generator.toSchema
import graphql.GraphQL

private val config = SchemaGeneratorConfig(
    supportedPackages = listOf(
        "com.digitaldesigns.shoppe.api.domain.models",
        "com.digitaldesigns.shoppe.api.features"
    )
)
private val queries = listOf(
    TopLevelObject(UserSchema.Queries()),
    TopLevelObject(ProductSchema.Queries()),
    TopLevelObject(ReviewSchema.Queries()),
    TopLevelObject(ShopSchema.Queries()),
)
private val mutations = listOf(
    TopLevelObject(AuthSchema.Mutations()),
    TopLevelObject(UserSchema.Mutations()),
    TopLevelObject(ProductSchema.Mutations()),
    TopLevelObject(ReviewSchema.Mutations()),
    TopLevelObject(ShopSchema.Mutations()),
)
val schema = toSchema(config, queries, mutations)

fun getGraphQLObject(): GraphQL = GraphQL.newGraphQL(schema)
    .valueUnboxer(IDValueUnboxer())
    .build()
