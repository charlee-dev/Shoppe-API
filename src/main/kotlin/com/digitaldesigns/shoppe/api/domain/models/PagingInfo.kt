package com.digitaldesigns.shoppe.api.domain.models

import com.digitaldesigns.shoppe.api.domain.util.Constants
import com.expediagroup.graphql.generator.annotations.GraphQLDescription

@GraphQLDescription(pagingInfoDescription)
data class PagingInfo(
    @GraphQLDescription(countDescription)
    var count: Int,
    @GraphQLDescription(pagesDescription)
    var pages: Int,
    @GraphQLDescription(nextDescription)
    var next: Int?,
    @GraphQLDescription(prevDescription)
    var prev: Int?,
)

@GraphQLDescription(pageInputDescription)
data class PageInput(
    val page: Int = 0,
    val size: Int = 10,
) {
    fun skips(): Int {
        return page * size
    }

    fun validate() {
        when {
            page < 0 -> error(Constants.Messages.PAGE_LESS_THAN_0)
            size < 1 -> error(Constants.Messages.SIZE_LESS_THAN_1)
        }
    }
}

data class Page<T>(
    val results: List<T>,
    val info: PagingInfo,
)

const val pagingInfoDescription = """
PagingInfo:
- count: Int
- pages: Int
- next: Int?
- prev: Int?
"""
const val pageInputDescription = """
PageInput:
- page: Int -> Default 0
- size: Int -> Default 10
"""
const val countDescription = "Current page number"
const val pagesDescription = "Number of total pages"
const val nextDescription = "Number of nex page -> Nullable"
const val prevDescription = "Number of previous page -> Nullable"
const val pageDescription = "placeholder"
