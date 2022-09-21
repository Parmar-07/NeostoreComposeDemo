package com.dp.neostore_data.source.models.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ProfileUserResponseModel(
    @Expose @SerializedName("user_data") var profileResponseModel : ProfileResponseModel,
)