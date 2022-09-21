package com.dp.neostore_data.source.models.request

import com.dp.neostore_data.source.models.request.ApiRequestModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class GetProductDetailRequestModel(
    val categoryId : Int,
    @Expose
    @SerializedName("product_id")
    val product_id: String
) : ApiRequestModel("products/getDetail")