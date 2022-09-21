package com.dp.neostore_data.source.models.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ProductImageResponseModel(
    @Expose @SerializedName("id") var id: Int = 0,
    @Expose @SerializedName("product_id") var product_id: Int = 0,
    @Expose @SerializedName("image") var image: String? = "",
    @Expose @SerializedName("created") var created: String? = "",
    @Expose @SerializedName("modified") var modified: String? = ""
)
