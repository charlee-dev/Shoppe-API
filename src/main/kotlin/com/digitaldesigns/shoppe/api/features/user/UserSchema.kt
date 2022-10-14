package com.digitaldesigns.shoppe.api.features.user

import com.digitaldesigns.shoppe.api.domain.util.withCurrentUser
import com.expediagroup.graphql.generator.annotations.GraphQLDescription
import com.expediagroup.graphql.server.operations.Mutation
import com.expediagroup.graphql.server.operations.Query
import graphql.schema.DataFetchingEnvironment
import org.koin.java.KoinJavaComponent.inject

class UserSchema {
    class Queries : Query {
        private val userService: UserService by inject(UserService::class.java)

        @GraphQLDescription("Get UserProfile")
        @Suppress("unused")
        fun getUserProfile(dfe: DataFetchingEnvironment): UserProfile {
            return dfe.withCurrentUser { userId ->
                userService.getUserProfile(userId)
            }
        }

        @GraphQLDescription("Get UserMinimal")
        @Suppress("unused")
        fun getUserMinimal(dfe: DataFetchingEnvironment): UserMinimal {
            return dfe.withCurrentUser { userId ->
                userService.getUserMinimal(userId)
            }
        }
    }

    class Mutations : Mutation {
        private val userService: UserService by inject(UserService::class.java)

        @GraphQLDescription("Update User")
        @Suppress("unused")
        fun updateUser(
            dfe: DataFetchingEnvironment,
            @GraphQLDescription(userInputDescription)
            userInput: UserInput,
        ): UserModel {
            return dfe.withCurrentUser { userId ->
                userService.updateUser(userId, userInput)
            }
        }

        @GraphQLDescription("Delete current User")
        @Suppress("unused")
        fun deleteUser(dfe: DataFetchingEnvironment): Boolean {
            return dfe.withCurrentUser { userId ->
                userService.deleteUser(userId)
            }
        }
    }
}
