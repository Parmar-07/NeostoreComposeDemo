package com.dp.neostore_domain.usecases

import com.dp.core.ResultWrapper
import com.dp.neostore_data.source.models.request.LoginRequestModel
import com.dp.neostore_data.source.models.response.ApiResponseModel
import com.dp.neostore_data.source.models.response.LoginResponseModel
 import com.dp.neostore_domain.base.UseCases
import com.dp.neostore_domain.data.LoginDataModel
import com.dp.neostore_domain.params.LoginParams
import com.dp.neostore_domain.repositories.AuthenticationRepository


class LoginUseCase(private val authenticationRepository: AuthenticationRepository) :
    UseCases<LoginParams, ApiResponseModel<LoginResponseModel>, LoginDataModel>() {

    override suspend fun buildUseCase(params: LoginParams): ResultWrapper<Throwable, LoginDataModel> {
        val loginRequestModel = LoginRequestModel(params.userName, params.password)
        return executeUseCase(authenticationRepository.login(loginRequestModel))

    }

    override fun onSuccessResultMapper(response: ApiResponseModel<LoginResponseModel>?): ResultWrapper<Throwable, LoginDataModel> {
        return ResultWrapper.build {
            val loginResponseModel: LoginResponseModel? = response?.data
            val loginDataModel = LoginDataModel()
            if (loginResponseModel != null) {
                loginDataModel.status = response.status == 200
                loginDataModel.userMsg = response.user_msg ?: ""
                loginDataModel.userEmail = loginResponseModel.email
                loginDataModel.userName = loginResponseModel.username
                loginDataModel.userImage = loginResponseModel.profile_pic

            }
            loginDataModel
        }
    }


}