package com.digitaldesigns.shoppe.api.features.auth

import at.favre.lib.crypto.bcrypt.BCrypt
import com.auth0.jwt.JWT
import com.auth0.jwt.JWTVerifier
import com.auth0.jwt.algorithms.Algorithm
import com.digitaldesigns.shoppe.api.domain.util.Constants
import com.digitaldesigns.shoppe.api.domain.util.Constants.Messages.TOKEN_FAILED_DECODE
import com.digitaldesigns.shoppe.api.graphql.ShoppeConfig
import graphql.GraphQLException

private const val CLAIM: String = "userId"
private const val BEARER = "Bearer "

class JwtService {
    private val secret: String = ShoppeConfig.jwtSecret
    private val algorithm = Algorithm.HMAC256(secret)
    private val verifier: JWTVerifier = JWT.require(algorithm).build()

    fun generateToken(id: String): String = JWT.create()
        .withIssuer(id)
        .withClaim(CLAIM, id)
        .sign(algorithm)

    fun validatePassword(password: String, hashedPass: ByteArray): Boolean {
        return if (!BCrypt.verifyer()
                .verify(password.toByteArray(Charsets.UTF_8), hashedPass).verified
        ) {
            throw GraphQLException(Constants.Messages.INVALID_CREDENTIALS)
        } else {
            true
        }
    }

    fun verifyToken(token: String): String {
        val split = token.split(BEARER).last()
        val result = verifier.verify(JWT.decode(split))
            ?.getClaim(CLAIM)
            ?.asString()
            ?: throw GraphQLException(TOKEN_FAILED_DECODE)
        result.ifBlank { throw GraphQLException(TOKEN_FAILED_DECODE) }
        return result
    }
}
