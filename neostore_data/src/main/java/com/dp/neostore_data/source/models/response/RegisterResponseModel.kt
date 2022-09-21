package com.dp.neostore_data.source.models.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RegisterResponseModel(

    @Expose @SerializedName("id") val id: Int=0,
    @Expose @SerializedName("role_id") val role_id: Int=0,
    @Expose @SerializedName("first_name") val first_name: String="",
    @Expose @SerializedName("last_name") val last_name: String="",
    @Expose @SerializedName("email") var email: String="",
    @Expose @SerializedName("username") val username: String="",
    @Expose @SerializedName("gender") val gender: String="",
    @Expose @SerializedName("phone_no") val phone_no: Long=0L,
    @Expose @SerializedName("is_active") val is_active: Boolean=false,
    @Expose @SerializedName("created") val created: String="",
    @Expose @SerializedName("modified") val modified: String="",
    @Expose @SerializedName("access_token") val access_token: String="",


)