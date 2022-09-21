package com.dp.neostore_data.source.models.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class ApiResponseModel<DataModel>{

    @Expose
    @SerializedName("status")
    var status: Int? = 0

    @Expose
    @SerializedName("message")
    var message: String? = null

    @Expose
    @SerializedName("user_msg")
    var user_msg: String? = null


    @Expose
    @SerializedName("data")
    var data: DataModel? = null


}