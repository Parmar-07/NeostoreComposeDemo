package com.dp.neostore_data.source.models.request

import com.dp.neostore_data.source.models.request.ApiRequestModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class GetProductsRequestModel(
    @Expose
    @SerializedName("product_category_id")
    val categoryId: String
) : ApiRequestModel("products/getList")