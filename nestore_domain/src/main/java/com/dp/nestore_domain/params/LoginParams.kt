package com.dp.nestore_domain.params

import com.dp.nestore_domain.base.UseCaseParams

data class LoginParams(val userName: String, val password: String) : UseCaseParams()