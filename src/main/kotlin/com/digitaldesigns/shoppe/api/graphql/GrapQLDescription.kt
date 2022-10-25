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

    object User {
        const val model = "User model."
        const val minimal = "User minimal model."
        const val input = "User input model."
        const val profile = "User profile with users list shops, products, reviews, orders"
        const val id = "User identifier."
        const val email = "User email format required eg: `email@test.com`"
        const val password = "User password. Special characters prohibited @£€#¢∞§¶•ªº\$%^&*()_+="
        const val displayName = "The user's display name. String. Max length 50 characters."
        const val userHandle = "User handle. Default is displayName. String. Max length 24 characters."
        const val imageUrl = "User image url."
        const val firstName = "Users first name"
        const val lastName = "Users last name"
        const val locale = "Users default localization"
        const val dateCreated = "Users creation date in GMT"
        const val lastModified = "Users last modification date in GMT"
    }

    object OrderItemTax {
        const val model = "Order line item tax entry."
        const val total = "The total tax for this tax rate on this item."
        const val subtotal = "The subtotal tax for this tax rate on this item."
    }

    object ShippingOrderAddress {
        const val model = "An order address."
        const val firstName = "The first name of the person in the address."
        const val lastName = "The last name of the person in the address."
        const val company = "The company name of the person in the address."
        const val address1 = "The first address line in the address."
        const val address2 = "The second address line in the address."
        const val city = "The city in the address."
        const val state = "The state in the address."
        const val postCode = "The postal code in the address."
        const val country = "The country code for the address."
    }

    object BillingOrderAddress {
        const val model = "An order billing address"
        const val email = "The email address of the person in the address."
        const val phone = "The phone number of the person in the address."
    }

    object OrderRefundLine {
        const val model = "Order refund line"
        const val reason = "The reason for giving the refund."
        const val total = "The total amount of the refund."
    }

    object OrderCouponLine {
        const val model = "Order coupon line"
        const val code = "The coupon code"
        const val discount = "The discount amount."
        const val discountTax = "The discount tax."
    }

    object OrderFeeLine {
        const val model = "Order fee line"
        const val name = "The name of the fee."
        const val taxClass = "The tax class of the fee."
        const val taxStatus = "The tax status of the fee."
        const val amount = "The total amount for this fee."
        const val total = "The display total amount for this fee."
        const val totalTax = "The total tax amount for this fee."
        const val taxes = "The taxes applied to this fee."
    }

    object OrderShippingLine {
        const val model = "Order shipping line"
        const val methodTitle = "The shipping method title."
        const val methodId = "The shipping method id."
        const val instanceId = "The shipping method instance id."
        const val total = "The total shipping amount for this method."
        const val totalTax = "The total tax amount for this shipping method."
        const val taxes = "The taxes applied to this shipping method."
    }

    object OrderTaxRate {
        const val model = ""
        const val rateCode = "The tax rate code."
        const val rateId = "The tax rate id."
        const val label = "The tax label."
        const val compoundRate = "Flag indicating whether it's a compound tax rate."
        const val taxTotal = "The total tax for this rate code."
        const val shippingTaxTotal = "The total shipping tax for this rate code."
        const val ratePercent = "The tax rate as a percentage."
    }

    object OrderLineItem {
        const val model = "Order Line Item"
        const val name = "The name of the product."
        const val productId = "The ID of the product."
        const val variationId = "The ID of the product variation."
        const val quantity = "The quantity of the product."
        const val taxClass = "The tax class for the product."
        const val subtotal = "The subtotal for the product."
        const val subtotalTax = "The subtotal tax for the product."
        const val total = "The total for the product including adjustments."
        const val totalTax = "The total tax for the product including adjustments."
        const val taxes = "The taxes applied to the product."
        const val sku = "The product SKU."
        const val price = "The price of the product."
        const val parentName = "The name of the parent product."
    }

    object Order {
        const val model = "An order object."
        const val createInput = "An order input object."
        const val parentId = "The parent order id."
        const val userId = "Id of user placing the order."
        const val status = "The order status."
        const val currency = "The order currency."
        const val version = "The WC version used to create the order."
        const val pricesIncludeTax = "Flags if the prices include tax."
        const val discountTotal = "The total of the discounts on the order."
        const val discountTax = "The total of the tax on discounts on the order."
        const val shippingTotal = "The total of the shipping on the order."
        const val shippingTax = "The total of the tax on shipping on the order."
        const val cartTax = "The total cart tax on the order."
        const val total = "The total for the order including adjustments."
        const val totalTax = "The total tax for the order including adjustments."
        const val customerId = "The customer id."
        const val billing = "The billing address."
        const val shipping = "The shipping address."
        const val paymentMethod = "Name of the payment method."
        const val transactionId = "Payment transaction ID."
        const val customerIpAddress = "Customer IP address."
        const val customerNote = "Customer note."
        const val dateCompleted = "Date the order was completed."
        const val datePaid = "Date the order was paid."
        const val orderNumber = "Number assigned to the order."
        const val currencySymbol = "Currency symbol for the order."
        const val setPaid = "The order's paid state."
        const val lineItems = "The order's line items."
        const val taxLines = "The order's tax rates."
        const val shippingLines = "The order's shipping charges."
        const val feeLines = "The order's fees."
        const val couponLines = "The coupons used on the order."
        const val refunds = "The refunds to the order."
    }

    object OrderStatus {
        const val model = "An order's status."
    }
}
