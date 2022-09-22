package com.dp.neostore_domain.base

interface IAppCache {

    fun writeString(cacheKey: String, cacheValue: String?)
    fun writeInt(cacheKey: String, cacheValue: Int)
    fun writeFloat(cacheKey: String, cacheValue: Float)
    fun writeBoolean(cacheKey: String, cacheValue: Boolean)
    fun <T> writeObject(cacheKey: String, data: T?)
    fun readStringCache(cacheKey: String): String
    fun readIntCache(cacheKey: String, defValue: Int = -1): Int
    fun readFloatCache(cacheKey: String): Float
    fun readBooleanCache(cacheKey: String): Boolean
    fun <T> readObject(cacheKey: String): T?
    fun clearCache(cacheKey: String)
    fun clearAllCache()

}