package com.dp.nestore_domain.repositories

import com.dp.neostore_data.source.apis.ApiException
import com.dp.neostore_data.source.models.request.LoginRequestModel
import com.dp.neostore_data.source.models.response.ApiResponseModel
import com.dp.neostore_data.source.models.response.LoginResponseModel
import com.dp.nestore_domain.base.ResultWrapper

interface IAuthenticationRepository {

    suspend fun login(requestModel: LoginRequestModel)
            : ResultWrapper<ApiException,
            ApiResponseModel<LoginResponseModel>>

}