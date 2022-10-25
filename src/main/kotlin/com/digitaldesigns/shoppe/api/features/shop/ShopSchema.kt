package com.digitaldesigns.shoppe.api.features.shop

import com.digitaldesigns.shoppe.api.domain.models.PageInput
import com.digitaldesigns.shoppe.api.domain.util.withCurrentUser
import com.digitaldesigns.shoppe.api.graphql.GraphQLDesc
import com.expediagroup.graphql.generator.annotations.GraphQLDescription
import com.expediagroup.graphql.server.operations.Mutation
import com.expediagroup.graphql.server.operations.Query
import graphql.schema.DataFetchingEnvironment
import org.koin.java.KoinJavaComponent.inject

class ShopSchema {
    class Queries : Query {
        private val shopService: ShopService by inject(ShopService::class.java)

        @GraphQLDescription("Search shop names that match query")
        @Suppress("unused")
        fun searchShopByName(
            @GraphQLDescription(GraphQLDesc.Shop.query)
            query: String,
            @GraphQLDescription(GraphQLDesc.PageInput.model)
            pageInput: PageInput,
        ): ShopPage {
            return shopService.getShopsByQuery(query, pageInput)
        }

        @GraphQLDescription("Get all shops of specific user")
        @Suppress("unused")
        fun getUserShops(
            @GraphQLDescription(GraphQLDesc.User.id)
            userId: String,
            @GraphQLDescription(GraphQLDesc.PageInput.model)
            pageInput: PageInput,
        ): ShopPage {
            return shopService.getShopsByUserId(userId, pageInput)
        }

        @GraphQLDescription("Get shop by id")
        @Suppress("unused")
        fun getShopById(
            @GraphQLDescription(GraphQLDesc.Shop.id)
            shopId: String,
        ): Shop {
            return shopService.getShopById(shopId)
        }
    }

    class Mutations : Mutation {
        private val shopService: ShopService by inject(ShopService::class.java)

        @GraphQLDescription("Get all shops from specific shop category")
        @Suppress("unused")
        fun createShop(
            dfe: DataFetchingEnvironment,
            @GraphQLDescription(GraphQLDesc.ShopInput.model)
            shopBasicInput: ShopInput,
        ): Shop {
            return dfe.withCurrentUser { userId ->
                shopService.addShop(userId, shopBasicInput)
            }
        }

        @GraphQLDescription("Get all shops from specific shop category")
        @Suppress("unused")
        fun updateShop(
            dfe: DataFetchingEnvironment,
            @GraphQLDescription(GraphQLDesc.Shop.id)
            shopId: String,
            @GraphQLDescription(GraphQLDesc.ShopInput.model)
            shopUpdateInput: ShopInput,
        ): Shop {
            return dfe.withCurrentUser { userId ->
                shopService.updateShop(userId, shopId, shopUpdateInput)
            }
        }

        @GraphQLDescription("Delete shop with id")
        @Suppress("unused")
        fun deleteShop(
            dfe: DataFetchingEnvironment,
            @GraphQLDescription(GraphQLDesc.Shop.id)
            shopId: String,
        ): Boolean {
            return dfe.withCurrentUser { userId ->
                shopService.deleteShop(userId, shopId)
            }
        }
    }
}
