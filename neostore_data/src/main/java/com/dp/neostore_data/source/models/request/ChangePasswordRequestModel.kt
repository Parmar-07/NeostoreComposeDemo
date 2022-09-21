package com.dp.neostore_data.source.models.request

import com.dp.neostore_data.source.models.request.ApiRequestModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ChangePasswordRequestModel(
    @Expose
    @SerializedName("old_password")
    val old_password: String,
    @Expose
    @SerializedName("password")
    val password: String,
    @Expose
    @SerializedName("confirm_password")
    val confirm_password: String
): ApiRequestModel("users/change")