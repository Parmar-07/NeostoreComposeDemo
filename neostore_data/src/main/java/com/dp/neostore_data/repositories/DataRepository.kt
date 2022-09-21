package com.dp.neostore_data.repositories

import com.dp.neostore_data.mapToGSONObj
import com.dp.neostore_data.source.apis.ApiException
import com.dp.neostore_data.source.models.response.ErrorResponseModel
import com.dp.nestore_domain.base.ResultWrapper
import retrofit2.Response
import java.net.UnknownHostException

open class DataRepository {

    protected fun <ResponseModel> executeApiCall(
        response: Response<ResponseModel>,
    ): ResultWrapper<ApiException, ResponseModel> {
        return try {
            if (response.isSuccessful) {
                ResultWrapper.Success(response.body()!!)
            } else {
                val code = response.code()
                val errorMsg = if (code in 400..503) {
                    val errorResponse: ErrorResponseModel? = response
                        .errorBody()
                        ?.string().mapToGSONObj(
                            ErrorResponseModel::class.java
                        )
                    errorResponse?.user_msg ?: response.message()
                } else {
                    response.message()
                }
                ResultWrapper.Error(ApiException(errorMsg).apply {
                    resCode = code
                })
            }
        } catch (e: Exception) {
            ResultWrapper.Error(ApiException(e.message))
        } catch (e: UnknownHostException) {
            ResultWrapper.Error(ApiException(e.message))
        }
    }
}