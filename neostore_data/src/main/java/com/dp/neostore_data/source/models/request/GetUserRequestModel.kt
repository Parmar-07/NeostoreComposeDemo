package com.dp.neostore_data.source.models.request

import com.dp.neostore_data.source.models.request.ApiRequestModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class GetUserRequestModel(
    @Expose
    @SerializedName("access_token")
    val access_token: String
) :

    ApiRequestModel("users/getUserData")