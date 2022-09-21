package com.dp.neostore_data.source.models.request

import com.dp.neostore_data.source.models.request.ApiRequestModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AddToCartRequestModel(

    @Expose
    @SerializedName("product_id")
    val product_id: Int,
    @Expose
    @SerializedName("quantity")
    val quantity: Int,
): ApiRequestModel("addToCart")