package com.digitaldesigns.shoppe.api.domain.util

object Constants {
    const val DATABASE_NAME = "Chores"
    const val USERS_COLLECTION = "Users"
    const val SHOPS_COLLECTION = "Shops"
    const val PRODUCTS_COLLECTION = "Products"
    const val REVIEW_COLLECTION = "Reviews"

    object Messages {
        const val NOT_SIGNED_IN = "Not signed in"
        const val INVALID_CREDENTIALS = "Invalid credentials"
        const val EMAIL_IN_USE = "Email already in use "
        const val TOKEN_EMPTY = "Token is empty"
        const val TOKEN_MISSING = "Authorization token missing"
        const val TOKEN_FAILED_DECODE = "Token is empty"
        const val NO_AUTH_HEADER = "Authorization token missing"
        const val INSUFFICIENT_PERMISSIONS = "Insufficient permissions"
        const val EMAIL_BLANK = "Email cannot be blank"
        const val EMAIL_INVALID_FORMAT = "Email invalid format"
        const val PASSWORD_BLANK = "Password cannot be blank"
        const val CANNOT_BE_BLANK = "Field cannot be blank"

        const val ITEM_WITH_THAT_ID_ALREADY_EXISTS = "Item with that id already exists"
        const val NO_ITEM_WITH_ID = "No item exists with id "
        const val PRODUCT_REVIEWS_NOT_FOUND = "Cannot find comments for task "
        const val UNKNOWN_ERROR = "Unknown error"

        const val DELETE_FAILED = "Cannot delete item "
        const val ADD_FAILED = "Cannot add item "
        const val UPDATE_FAILED = "Cannot update item "
        const val DELETED = "Deleted item with id "

        const val PAGE_LESS_THAN_0 = "Page number cannot be less than 0"
        const val SIZE_LESS_THAN_1 = "Size number cannot be less than 1"
        const val TOTAL_PAGES = "Total number of pages is"

        const val USER_REVIEWS_NOT_FOUND = "User reviews not found"
    }
}
