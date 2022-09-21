package com.dp.neostore_data.source.models.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UpdateProfileResponseModel(
    @Expose @SerializedName("id") var id: Long = 0L,
    @Expose @SerializedName("role_id") var role_id: Int = 0,
    @Expose @SerializedName("first_name") var first_name: String? = "",
    @Expose @SerializedName("last_name") var last_name: String? = "",
    @Expose @SerializedName("email") var email: String? = "",
    @Expose @SerializedName("username") var username: String? = "",
    @Expose @SerializedName("profile_pic") var profile_pic: String? = "",
    @Expose @SerializedName("country_id") var country_id: String? = "",
    @Expose @SerializedName("gender") var gender: String? = "",
    @Expose @SerializedName("phone_no") var phone_no: String? = "",
    @Expose @SerializedName("dob") var dob: String? = "",
    @Expose @SerializedName("is_active") var is_active: Boolean = false,
    @Expose @SerializedName("created") var created: String? = "",
    @Expose @SerializedName("modified") var modified: String? = "",
    @Expose @SerializedName("access_token") var access_token: String? = ""
)