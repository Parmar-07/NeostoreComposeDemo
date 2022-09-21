package com.dp.neostore_data

import com.google.gson.Gson

fun <T>String?.mapToGSONObj(clazz: Class<T>):T? {
    return try {
        Gson().fromJson(this,clazz)
    }catch (e:Exception){
        null
    }
}