package com.dp.neostore_data.source.models.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ProfileResponseModel(
    @Expose @SerializedName("access_token") val access_token: String="",
    @Expose @SerializedName("country_id") val country_id: String="",
    @Expose @SerializedName("created") val created: String="",
    @Expose @SerializedName("dob") var dob: String="",
    @Expose @SerializedName("email") var email: String="",
    @Expose @SerializedName("first_name") var first_name: String="",
    @Expose @SerializedName("gender") val gender: String="",
    @Expose @SerializedName("id") val id: Int=0,
    @Expose @SerializedName("is_active") val is_active: Boolean=false,
    @Expose @SerializedName("last_name") var last_name: String="",
    @Expose @SerializedName("modified") val modified: String="",
    @Expose @SerializedName("phone_no") var phone_no:String="",
    @Expose @SerializedName("profile_pic") var profile_pic: String="",
    @Expose @SerializedName("role_id") val role_id: Int=0,
    @Expose @SerializedName("username") var username: String=""
)