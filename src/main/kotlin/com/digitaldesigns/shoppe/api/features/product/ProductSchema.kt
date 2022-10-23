package com.digitaldesigns.shoppe.api.features.product

import com.digitaldesigns.shoppe.api.domain.models.PageInput
import com.digitaldesigns.shoppe.api.domain.util.withCurrentUser
import com.digitaldesigns.shoppe.api.features.product.model.Product
import com.digitaldesigns.shoppe.api.features.product.model.ProductCategory
import com.digitaldesigns.shoppe.api.features.product.model.ProductCreateInput
import com.digitaldesigns.shoppe.api.features.product.model.ProductPage
import com.digitaldesigns.shoppe.api.features.product.model.ProductUpdateInput
import com.expediagroup.graphql.generator.annotations.GraphQLDescription
import com.expediagroup.graphql.server.operations.Mutation
import com.expediagroup.graphql.server.operations.Query
import graphql.schema.DataFetchingEnvironment
import org.koin.java.KoinJavaComponent.inject

class ProductSchema {
    class Queries : Query {
        private val productService: ProductService by inject(ProductService::class.java)

        @GraphQLDescription("Search product names that match query")
        @Suppress("unused")
        fun searchProductByName(
            query: String,
            pageInput: PageInput,
        ): ProductPage {
            return productService.queryAllProductNamesByQuery(query, pageInput)
        }

        @GraphQLDescription("Get all products of specific user")
        @Suppress("unused")
        fun getUserProducts(
            userId: String,
            pageInput: PageInput,
        ): ProductPage {
            return productService.getProductsByUserId(userId, pageInput)
        }

        @GraphQLDescription("Get all products of specific user")
        @Suppress("unused")
        fun getShopProducts(
            shopId: String,
            pageInput: PageInput,
        ): ProductPage {
            return productService.getProductsByShopId(shopId, pageInput)
        }

        @GraphQLDescription("Get all products from specific product category")
        @Suppress("unused")
        fun getProductsByProductCategory(
            category: ProductCategory,
            pageInput: PageInput,
        ): ProductPage {
            return productService.getProductsByCategory(category, pageInput)
        }
    }

    class Mutations : Mutation {
        private val productService: ProductService by inject(ProductService::class.java)

        @GraphQLDescription("Get all products from specific product category")
        @Suppress("unused")
        fun createProduct(
            dfe: DataFetchingEnvironment,
            shopId: String,
            productCreateInput: ProductCreateInput,
        ): Product {
            return dfe.withCurrentUser { userId ->
                productService.addProduct(userId, shopId, productCreateInput)
            }
        }

        @GraphQLDescription("Get all products from specific product category")
        @Suppress("unused")
        fun updateProduct(
            dfe: DataFetchingEnvironment,
            productId: String,
            shopId: String,
            productUpdateInput: ProductUpdateInput,
        ): Product {
            return dfe.withCurrentUser { userId ->
                productService.updateProduct(userId, shopId, productId, productUpdateInput)
            }
        }

        @GraphQLDescription("Get all products from specific product category")
        @Suppress("unused")
        fun deleteProduct(
            dfe: DataFetchingEnvironment,
            productId: String,
        ): Boolean {
            return dfe.withCurrentUser { userId ->
                productService.deleteProduct(userId, productId)
            }
        }
    }
}
