package com.dp.neostore_data.source.models.request

import com.dp.neostore_data.source.models.request.ApiRequestModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UpdateProfileRequestModel(


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
    @SerializedName("dob")
    var dob: String="",
    @Expose
    @SerializedName("phone_no")
    var phone_no: String="",
    @Expose
    @SerializedName("profile_pic")
    var profile_pic: String = ""

) : ApiRequestModel("users/update")



