package com.digitaldesigns.shoppe.api.graphql

object GraphQLDesc {

    object Product {
        const val model = "The base for all product types."
        const val id = "Product identifier."
        const val variationId = "Product variation identifier."
        const val shopId = "Identifier of the shop product belongs to."
        const val userId = "Identifier of user, that created the product."
        const val name = "The name of the product."
        const val slug = "The slug of the product."
        const val created = "The GMT datetime when the product was created."
        const val modified = "The GMT datetime when the product was last modified."
        const val desc = "The product's short description."
        const val categories = "An array of the categories this product is in."
        const val tags = "An array of the tags this product has."
        const val colors = "An array of product colors."
        const val isFeatured = "Indicates whether or not the product should be featured."
        const val totalSales = "The count of sales of the product."
        const val images = "List of product images"
        const val image = "Product variation images"
        const val allowReviews = "Indicates whether or not a product allows reviews."
        const val averageRating = "The average rating for the product."
        const val numRatings = "The number of ratings for the product."
        const val relatedIds = "An array of IDs of related products."
        const val attributes = "The attributes for the product."
        const val links = "The product's links."
        const val rating = "The product's rating."

        const val productIds = "An array of cross sell product ids string."

        const val isVirtual = "Indicates that the product is delivered virtually."
        const val isDownloadable = "Indicates whether or not the product is downloadable."
        const val downloads = "The downloads available for the product."
        const val downloadLimit = "The maximum number of times a customer may download the product's contents."
        const val daysToDownload =
            "The number of days after purchase that a customer may still download the product's contents."
        const val purchaseNote = "The text shown to the customer on completing the purchase of this product."

        const val onePreOrder = "Indicates that only one of a product may be held in the order at a time."
        const val trackInventory = "Indicates that a product should use the inventory system."
        const val remainingStock = "The number of inventory units remaining for this product."
        const val stockStatus = "The product's stock status."
        const val backorderStatus = "The status of back-ordering for a product."
        const val canBackorder = "Indicates whether or not a product can be back-ordered."
        const val isOnBackorder = "Indicates whether or not a product is on backorder."
        const val lowStockThreshold =
            "Indicates the threshold for when the low stock notification will be sent to the merchant."

        const val price = "The current price of the product."
        const val regularPrice = "The regular price of the product when not discounted."
        const val onSale = "Indicates whether or not the product is currently on sale."
        const val salePrice = "The price of the product when on sale."
        const val saleStart = "The GMT datetime when the product should start to be on sale."
        const val saleEnd = "The GMT datetime when the product should no longer be on sale."

        const val weight = "The weight of the product in the store's current units."
        const val weightUnit = "The weight unit of the product."
        const val length = "The length of the product in the store's current units."
        const val width = "The width of the product in the store's current units."
        const val height = "The height of the product in the store's current units."
        const val measureUnit = "The measure unit  of the product."
        const val requiresShipping = "Indicates that the product must be shipped."
        const val isShippingTaxable = "Indicates that the product's shipping is taxable."
        const val shippingClass = "The shipping class for the product."
        const val shippingClassId = "The shipping class ID for the product."
    }

    object ProductAttribute {
        const val model = "A product's attributes."
        const val input = "A product's attributes input."
        const val sortOrder = "The sort order of the attribute."
        const val isVisibleOnProductPage = "Indicates whether or not the attribute is visible on the product page."
        const val isForVariations = "Indicates whether or not the attribute should be used in variations."
        const val options = "The options which are available for the attribute."
    }

    object SortOrder {
        const val model = "Product sort order"
        const val asc = "Product sort order ascending"
        const val desc = "Product sort order descending"
    }

    object ProductCategory {
        const val model = "Category tag"
        const val name = "Category tag name"
        const val isCustom = "Indicates if category is custom"
        const val createdDate = "Category creation date"
        const val createdBy = "Specifies who created the category"
    }

    object ProductTag {
        const val model = "Product tag"
        const val name = "Product tag name"
        const val isCustom = "Indicates if tag is custom"
        const val createdDate = "Tag creation date"
        const val createdBy = "Specifies who created the tag"
    }

    object ProductImage {
        const val model = "A product's image."
        const val id = "The ID of the image."
        const val created = "The GMT datetime when the image was created."
        const val modified = "The GMT datetime when the image was last modified."
        const val url = "The URL for the image file."
        const val name = "The name of the image file."
        const val altText = "The alt text to use on the image."
    }

    object ProductDownload {
        const val model = "A product's download."
        const val id = "The ID of the downloadable file."
        const val name = "The name of the downloadable file."
        const val url = "The URL of the downloadable file."
    }

    object Review {
        const val model = "Product review model"
        const val input = "Product review input model"
        const val id = "Unique identifier for the resource."
        const val authorId = "Reviewer identifier."
        const val productId = "Unique identifier for the product that the review belongs to."
        const val text = "The content of the review."
        const val rating = "integer 0 to 5"
        const val dateCreated = "The date the review was created, in the site's timezone."
        const val verified = "Shows if the reviewer bought the product or not."
    }

    object ReviewPage {
        const val page = "Page with Product Reviews and PageInfo"
        const val results = "List of Reviews"
        const val info = "PageInfo model"
    }
}
