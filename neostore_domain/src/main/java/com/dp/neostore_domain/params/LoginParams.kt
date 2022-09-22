package com.dp.neostore_domain.params

import com.dp.neostore_domain.base.UseCaseParams

data class LoginParams(val userName: String, val password: String) : UseCaseParams()