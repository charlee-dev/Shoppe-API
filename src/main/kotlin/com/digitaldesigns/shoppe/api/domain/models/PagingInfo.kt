package com.digitaldesigns.shoppe.api.domain.models

import com.digitaldesigns.shoppe.api.domain.util.Constants
import com.digitaldesigns.shoppe.api.graphql.GraphQLDesc
import com.expediagroup.graphql.generator.annotations.GraphQLDescription

@GraphQLDescription(GraphQLDesc.PagingInfo.model)
data class PagingInfo(
    @GraphQLDescription(GraphQLDesc.PagingInfo.count)
    var count: Int,
    @GraphQLDescription(GraphQLDesc.PagingInfo.pages)
    var pages: Int,
    @GraphQLDescription(GraphQLDesc.PagingInfo.next)
    var next: Int?,
    @GraphQLDescription(GraphQLDesc.PagingInfo.prev)
    var prev: Int?,
)

@GraphQLDescription(GraphQLDesc.PageInput.model)
data class PageInput(
    @GraphQLDescription(GraphQLDesc.PageInput.page)
    val page: Int = 0,
    @GraphQLDescription(GraphQLDesc.PageInput.size)
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
