package com.dp.nestore_domain.data

import com.dp.nestore_domain.base.UseCaseData

class LoginDataModel : UseCaseData() {
    var userEmail: String? = null
    var userName: String? = null
    var userImage: String? = null
}