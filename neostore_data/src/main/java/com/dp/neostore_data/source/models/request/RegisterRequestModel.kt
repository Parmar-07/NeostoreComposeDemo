package com.dp.neostore_data.source.models.request

import com.dp.neostore_data.source.models.request.ApiRequestModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RegisterRequestModel(

    @Expose
    @SerializedName("first_name")
    var first_name: String="",
    @Expose
    @SerializedName("last_name")
    var last_name: String="",
    @Expose
    @SerializedName("email")
    var email: String="",
    @Expose
    @SerializedName("password")
    var password: String="",
    @Expose
    @SerializedName("confirm_password")
    var confirm_password: String="",
    @Expose
    @SerializedName("gender")
    var gender: String="",
    @Expose
    @SerializedName("phone_no")
    var phone_no: Number = 0
) : ApiRequestModel("users/register")



