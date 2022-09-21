package com.dp.neostore_data.repositories

import com.dp.neostore_data.source.apis.ApiException
import com.dp.neostore_data.source.apis.NeoStoreApis
import com.dp.neostore_data.source.models.request.LoginRequestModel
import com.dp.neostore_data.source.models.response.ApiResponseModel
import com.dp.neostore_data.source.models.response.LoginResponseModel
import com.dp.nestore_domain.base.ResultWrapper
import com.dp.nestore_domain.repositories.IAuthenticationRepository

class AuthenticationRepository(private val neoStoreApis: NeoStoreApis) : DataRepository(),
    IAuthenticationRepository {

    override suspend fun login(requestModel: LoginRequestModel): ResultWrapper<ApiException, ApiResponseModel<LoginResponseModel>> {
        return executeApiCall(
            neoStoreApis.login(
                requestModel.apiPath,
                requestModel.email,
                requestModel.password
            )
        )
    }

}