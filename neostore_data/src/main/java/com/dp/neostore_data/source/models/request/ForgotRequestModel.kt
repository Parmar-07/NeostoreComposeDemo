package com.dp.neostore_data.source.models.request

import com.dp.neostore_data.source.models.request.ApiRequestModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ForgotRequestModel(
    @Expose
    @SerializedName("email")
    val email: String
): ApiRequestModel("users/forgot")