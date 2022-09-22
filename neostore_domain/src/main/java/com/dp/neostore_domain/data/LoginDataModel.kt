package com.dp.neostore_domain.data

import com.dp.neostore_domain.base.UseCaseData

class LoginDataModel : UseCaseData() {
    var userEmail: String? = null
    var userName: String? = null
    var userImage: String? = null
}