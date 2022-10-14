package com.digitaldesigns.shoppe.api.features.auth

import com.digitaldesigns.shoppe.api.domain.util.Constants
import com.digitaldesigns.shoppe.api.domain.util.encrypt
import com.digitaldesigns.shoppe.api.features.user.UserModel
import com.digitaldesigns.shoppe.api.features.user.UserRepository
import graphql.GraphQLException

class AuthService(
    private val userRepository: UserRepository,
    private val jwtService: JwtService,
) {
    fun signIn(authInput: AuthInput): AuthResponse {
        authInput.validate()
        val user = userRepository.getUserByEmail(authInput.email)
            ?: throw GraphQLException(Constants.Messages.INVALID_CREDENTIALS)
        jwtService.validatePassword(authInput.password, user.hashedPass)
        val token = jwtService.generateToken(user.id)
        return AuthResponse(token, user.toMinimal())
    }

    fun signUp(authInput: AuthInput): AuthResponse {
        authInput.validate()
        userRepository throwIfUserWithThatEmailExists authInput.email
        val newUser = userRepository.add(
            UserModel(
                email = authInput.email,
                hashedPass = authInput.password.encrypt()
            )
        )
        val token = jwtService.generateToken(newUser.id)
        return AuthResponse(token, newUser.toMinimal())
    }
}
