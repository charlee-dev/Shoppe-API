package com.digitaldesigns.shoppe.api.helpers

import com.digitaldesigns.shoppe.api.domain.models.Model
import com.digitaldesigns.shoppe.api.domain.repository.CrudRepository
import com.digitaldesigns.shoppe.api.features.auth.AuthInput
import com.digitaldesigns.shoppe.api.features.auth.AuthService
import com.digitaldesigns.shoppe.api.mock.password1
import com.digitaldesigns.shoppe.api.mock.user1

internal suspend fun <T : Model> CrudRepository<T>.populateDatabase(
    items: List<T>,
    itemsToAdd: Int = 1,
    block: suspend () -> Unit,
) {
    (1..itemsToAdd).forEach { _ ->
        items.forEach { add(it) }
    }
    block()
    getAll()
        .map { it.id }
        .forEach { delete(it) }
}

// fun ContextBuilder.buildContext(call: ApplicationCall) {
//    JwtService().verifyToken(call)?.let { +it }
// }

fun AuthService.getToken(input: AuthInput = AuthInput(user1.email, password1)): String =
    signIn(input).token
