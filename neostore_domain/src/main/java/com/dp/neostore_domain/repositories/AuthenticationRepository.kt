package com.dp.neostore_domain.repositories

 import com.dp.neostore_domain.base.ResultWrapper
 import com.dp.neostore_data.source.apis.ApiException
import com.dp.neostore_data.source.apis.NeoStoreApis
import com.dp.neostore_data.source.models.request.LoginRequestModel
import com.dp.neostore_data.source.models.response.ApiResponseModel
import com.dp.neostore_data.source.models.response.LoginResponseModel

class AuthenticationRepository(private val neoStoreApis: NeoStoreApis) : DataRepository() {

    suspend fun login(requestModel: LoginRequestModel): ResultWrapper<ApiException, ApiResponseModel<LoginResponseModel>> {
        return executeApiCall(
            neoStoreApis.login(
                requestModel.apiPath,
                requestModel.email,
                requestModel.password
            )
        )
    }

}