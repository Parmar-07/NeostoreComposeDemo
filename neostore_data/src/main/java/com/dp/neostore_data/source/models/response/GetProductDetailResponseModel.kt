package com.dp.neostore_data.source.models.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class GetProductDetailResponseModel(
    @Expose @SerializedName("id") val id: Long = 0L,
    @Expose @SerializedName("product_category_id") val product_category_id: Long = 0L,
    @Expose @SerializedName("name") var name: String = "",
    @Expose @SerializedName("producer") val producer: String = "",
    @Expose @SerializedName("description") var description: String = "",
    @Expose @SerializedName("cost") var cost: Float = 0f,
    @Expose @SerializedName("rating") val rating: Long = 0L,
    @Expose @SerializedName("view_count") val view_count: Long = 0L,
    @Expose @SerializedName("created") val created: String = "",
    @Expose @SerializedName("modified") val modified: String = "",
    @Expose @SerializedName("product_images") var product_images: List<ProductImageResponseModel> ? =null
)