package com.digitaldesigns.shoppe.api.helpers

import co.touchlab.kermit.Logger
import com.digitaldesigns.shoppe.api.features.auth.AuthService
import com.digitaldesigns.shoppe.api.features.auth.JwtService
import com.digitaldesigns.shoppe.api.features.product.ProductRepository
import com.digitaldesigns.shoppe.api.features.product.ProductService
import com.digitaldesigns.shoppe.api.features.product.model.Product
import com.digitaldesigns.shoppe.api.features.review.Review
import com.digitaldesigns.shoppe.api.features.review.ReviewRepository
import com.digitaldesigns.shoppe.api.features.review.ReviewService
import com.digitaldesigns.shoppe.api.features.shop.Shop
import com.digitaldesigns.shoppe.api.features.shop.ShopRepository
import com.digitaldesigns.shoppe.api.features.shop.ShopService
import com.digitaldesigns.shoppe.api.features.user.UserModel
import com.digitaldesigns.shoppe.api.features.user.UserRepository
import com.digitaldesigns.shoppe.api.features.user.UserService
import com.digitaldesigns.shoppe.api.graphql.getGraphQLObject
import com.digitaldesigns.shoppe.api.mock.MockProvider
import com.digitaldesigns.shoppe.api.mock.mockProducts
import com.digitaldesigns.shoppe.api.mock.mockReviews
import com.digitaldesigns.shoppe.api.mock.mockShops
import com.digitaldesigns.shoppe.api.mock.mockUsers
import com.digitaldesigns.shoppe.api.mock.user1
import com.expediagroup.graphql.server.execution.GraphQLRequestHandler
import com.expediagroup.graphql.server.types.GraphQLRequest
import com.expediagroup.graphql.server.types.GraphQLResponse
import io.ktor.server.testing.testApplication
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.dsl.module
import org.koin.java.KoinJavaComponent.inject
import kotlin.test.AfterTest
import kotlin.test.BeforeTest

open class SchemaTest {
    @BeforeTest
    fun setup() {
        startKoin {
            modules(testModule)
        }
    }

    @AfterTest
    fun teardown() {
        stopKoin()
    }

    private val testModule = module {
        single { MockProvider.userRepository }
        single { MockProvider.productRepository }
        single { MockProvider.reviewRepository }
        single { MockProvider.shopRepository }
        single { JwtService() }
        single { AuthService(get(), get()) }
        single { UserService(get(), get(), get(), get()) }
        single { ProductService(get(), get()) }
        single { ReviewService(get(), get()) }
        single { ShopService(get(), get(), get()) }
    }

    fun test(
        users: List<UserModel> = mockUsers,
        shops: List<Shop> = mockShops,
        products: List<Product> = mockProducts,
        reviews: List<Review> = mockReviews,
        query: String,
        variables: Map<String, Any?>? = emptyMap(),
        graphQLContext: Map<*, Any> = mapOf("id" to user1.id),
        assert: suspend (GraphQLResponse<*>) -> Unit,
    ) {
        val userRepository: UserRepository by inject(UserRepository::class.java)
        val shopRepository: ShopRepository by inject(ShopRepository::class.java)
        val productRepository: ProductRepository by inject(ProductRepository::class.java)
        val reviewRepository: ReviewRepository by inject(ReviewRepository::class.java)
        val graphQLRequestHandler = GraphQLRequestHandler(getGraphQLObject())

        testApplication {
            userRepository.populateDatabase(users) {
                productRepository.populateDatabase(products) {
                    shopRepository.populateDatabase(shops) {
                        reviewRepository.populateDatabase(reviews) {
                            val request = GraphQLRequest(query, null, variables, null)
                            Logger.v("😇✉️ REQUEST = \n$request\n")
                            val response = graphQLRequestHandler.executeRequest(
                                request,
                                graphQLContext = graphQLContext
                            ) as GraphQLResponse<*>
                            Logger.v(
                                "😇✉️ RESPONSE = \n" +
                                    "data = ${response.data}\n" +
                                    "errors = ${response.errors}\n"
                            )
                            assert(response)
                        }
                    }
                }
            }
        }
    }
}
