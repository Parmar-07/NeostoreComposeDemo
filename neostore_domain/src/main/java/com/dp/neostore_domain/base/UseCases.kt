package com.dp.neostore_domain.base

import com.dp.core.ResultWrapper
import com.dp.neostore_data.source.apis.ApiException


abstract class UseCases<in Params : UseCaseParams, Response, out Data : UseCaseData> {

    abstract suspend fun buildUseCase(params: Params): ResultWrapper<Throwable, Data>

    abstract fun onSuccessResultMapper(response: Response?): ResultWrapper<Throwable, Data>

    protected fun executeUseCase(responseData: ResultWrapper<Throwable, Response>): ResultWrapper<Throwable, Data> {
        return when (responseData) {
            is ResultWrapper.Success -> onSuccessResultMapper(responseData.value)
            is ResultWrapper.Error -> onErrorResultMapper(responseData.error)
        }
    }

    private fun onErrorResultMapper(error: Throwable): ResultWrapper<ApiException, Data> {
        return if (error is ApiException) {
            ResultWrapper.Error(error)
        } else {
            ResultWrapper.Error(ApiException(error.message))
        }

    }


}