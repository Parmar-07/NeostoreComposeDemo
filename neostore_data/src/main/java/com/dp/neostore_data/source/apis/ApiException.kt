package com.dp.neostore_data.source.apis

open class ApiException (val errorMsg: String?) : Throwable() {

    override val message: String?
        get() = errorMsg

    var resCode = -1
}