package com.digitaldesigns.shoppe.api.graphql

object GraphQLDesc {

    object Product {
        object Common {
            const val model = "The base for all product types."
            const val input = "The base for all product types input."
            const val id = "Product identifier."
            const val shopId = "Identifier of the shop product becongs to."
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
            const val catalogVisibility = "Indicates whether or not the product should be visible in the catalog."
            const val totalSales = "The count of sales of the product."
            const val images = "Product images"
            const val allowReviews = "Indicates whether or not a product allows reviews."
            const val averageRating = "The average rating for the product."
            const val numRatings = "The number of ratings for the product."
            const val relatedIds = "An array of IDs of related products."
            const val attributes = "The attributes for the product."
            const val links = "The product's links."
            const val rating = "The product's rating."
        }

        object CrossSells {
            const val model = "The base for cross sells."
            const val input = "The base for cross sells input."
            const val productIds = "An array of cross sell product ids string."
        }

        object Data {
            const val model = "Base product data"
            const val input = "Base product data input"
            const val permalink = "The permalink of the product."
            const val productId = "The Id of the product"
            const val parentId = ""
            const val menuOrder = "The menu order assigned to the product."
            const val created = "The GMT datetime when the product was created."
            const val modified = "The GMT datetime when the product was last modified."
            const val postStatus = "The product's current post status."
            const val description = "The product's full description."
            const val sku = "The product's SKU."
            const val isPurchasable = "Indicates whether or not the product is currently able to be purchased."
            const val images = "The images for the product."
            const val metaData = "The extra metadata for the product."
            const val links = "The product data links."
        }

        object Delivery {
            const val model = "The base for Delivery products."
            const val input = "The base for Delivery products input."
            const val isVirtual = "Indicates that the product is delivered virtually."
            const val isDownloadable = "Indicates whether or not the product is downloadable."
            const val downloads = "The downloads available for the product."
            const val downloadLimit = "The maximum number of times a customer may download the product's contents."
            const val daysToDownload =
                "The number of days after purchase that a customer may still download the product's contents."
            const val purchaseNote = "The text shown to the customer on completing the purchase of this product."
        }

        object Grouped {
            const val model = "The base for cross sells."
            const val input = "The base for cross sells input."
            const val groupedProducts = "An array of grouped product ids."
        }

        object Inventory {
            const val model = "The base for inventory products."
            const val input = "The base for inventory products input."
            const val onePreOrder = "Indicates that only one of a product may be held in the order at a time."
            const val trackInventory = "Indicates that a product should use the inventory system."
            const val remainingStock = "The number of inventory units remaining for this product."
            const val stockStatus = "The product's stock status."
            const val backorderStatus = "The status of back-ordering for a product."
            const val canBackorder = "Indicates whether or not a product can be back-ordered."
            const val isOnBackorder = "Indicates whether or not a product is on backorder."
            const val lowStockThreshold =
                "Indicates the threshold for when the low stock notification will be sent to the merchant."
        }

        object Price {
            const val model = "The base for price properties."
            const val input = "The base for price properties."
            const val price = "The current price of the product."
            const val regularPrice = "The regular price of the product when not discounted."
            const val onSale = "Indicates whether or not the product is currently on sale."
            const val salePrice = "The price of the product when on sale."
            const val saleStart = "The GMT datetime when the product should start to be on sale."
            const val saleEnd = "The GMT datetime when the product should no longer be on sale."
        }

        object Attribute {
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

        object SalesTax {
            const val model = "The base for products with sales tax."
            const val input = "The base for products with sales tax input."
            const val taxStatus = "The taxability of the product."
            const val taxClass = "The tax class of the product"
        }

        object Shipping {
            const val model = "The base class for product shipping."
            const val input = "The base class for product shipping input."
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

        object Category {
            const val model = "Category tag"
            const val input = "Category tag input"
            const val name = "Category tag name"
            const val isCustom = "Indicates if category is custom"
            const val createdDate = "Category creation date"
            const val createdBy = "Specifies who created the category"
        }

        object Tag {
            const val model = "Product tag"
            const val input = "Product tag input"
            const val name = "Product tag name"
            const val isCustom = "Indicates if tag is custom"
            const val createdDate = "Tag creation date"
            const val createdBy = "Specifies who created the tag"
        }

        object Image {
            const val model = "A product's image."
            const val input = "A product's image input."
            const val id = "The ID of the image."
            const val created = "The GMT datetime when the image was created."
            const val modified = "The GMT datetime when the image was last modified."
            const val url = "The URL for the image file."
            const val name = "The name of the image file."
            const val altText = "The alt text to use on the image."
        }

        object Download {
            const val model = "A product's download."
            const val input = "A product's download input."
            const val id = "The ID of the downloadable file."
            const val name = "The name of the downloadable file."
            const val url = "The URL of the downloadable file."
        }

        object CatalogVisibility {
            const val model = "An enum describing the catalog visibility options for products."
            const val everywhere = "The product should be visible everywhere."
            const val hidden = "The product should be hidden everywhere."
        }

        object BackorderStatus {
            const val model = "Indicates the status for backorders for a product."
            const val allowed = "The product is allowed to be backordered."
            const val notAllowed =
                "The product is allowed to be backordered but it will notify the customer of that fact."
        }

        @Suppress("SpellCheckingInspection")
        object Taxability {
            const val model = ""
            const val productAndShipping = "The product and shipping are both taxable."
            const val shippingOnly = "Only the product's shipping is taxable."
            const val none = "The product and shipping are not taxable."
        }
    }
}
