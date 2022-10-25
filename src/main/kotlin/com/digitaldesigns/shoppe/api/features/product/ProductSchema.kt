package com.digitaldesigns.shoppe.api.features.product

import com.digitaldesigns.shoppe.api.domain.models.PageInput
import com.digitaldesigns.shoppe.api.domain.util.withCurrentUser
import com.digitaldesigns.shoppe.api.features.product.model.Product
import com.digitaldesigns.shoppe.api.features.product.model.ProductCategory
import com.digitaldesigns.shoppe.api.features.product.model.ProductCreateInput
import com.digitaldesigns.shoppe.api.features.product.model.ProductPage
import com.digitaldesigns.shoppe.api.features.product.model.ProductUpdateInput
import com.digitaldesigns.shoppe.api.graphql.GraphQLDesc
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
            @GraphQLDescription(GraphQLDesc.Product.query)
            query: String,
            @GraphQLDescription(GraphQLDesc.PageInput.model)
            pageInput: PageInput,
        ): ProductPage {
            return productService.queryAllProductNamesByQuery(query, pageInput)
        }

        @GraphQLDescription("Get all products of specific user")
        @Suppress("unused")
        fun getUserProducts(
            @GraphQLDescription(GraphQLDesc.Product.userId)
            userId: String,
            @GraphQLDescription(GraphQLDesc.PageInput.model)
            pageInput: PageInput,
        ): ProductPage {
            return productService.getProductsByUserId(userId, pageInput)
        }

        @GraphQLDescription("Get all products of specific user")
        @Suppress("unused")
        fun getShopProducts(
            @GraphQLDescription(GraphQLDesc.Product.shopId)
            shopId: String,
            @GraphQLDescription(GraphQLDesc.PageInput.model)
            pageInput: PageInput,
        ): ProductPage {
            return productService.getProductsByShopId(shopId, pageInput)
        }

        @GraphQLDescription("Get all products from specific product category")
        @Suppress("unused")
        fun getProductsByProductCategory(
            @GraphQLDescription(GraphQLDesc.Product.category)
            category: ProductCategory,
            @GraphQLDescription(GraphQLDesc.PageInput.model)
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
            @GraphQLDescription(GraphQLDesc.Product.shopId)
            shopId: String,
            @GraphQLDescription(GraphQLDesc.Product.createInput)
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
            @GraphQLDescription(GraphQLDesc.Product.id)
            productId: String,
            @GraphQLDescription(GraphQLDesc.Product.shopId)
            shopId: String,
            @GraphQLDescription(GraphQLDesc.Product.updateInput)
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
            @GraphQLDescription(GraphQLDesc.Product.id)
            productId: String,
        ): Boolean {
            return dfe.withCurrentUser { userId ->
                productService.deleteProduct(userId, productId)
            }
        }
    }
}
