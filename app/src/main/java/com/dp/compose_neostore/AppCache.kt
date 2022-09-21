package com.dp.compose_neostore

import android.content.Context
import android.content.SharedPreferences
import com.dp.nestore_domain.base.IAppCache
import java.io.*

class AppCache constructor(private val context: Context) : IAppCache {

    private val prefs: SharedPreferences =
        context.getSharedPreferences("AppCache", Context.MODE_PRIVATE)

    override fun writeString(cacheKey: String, cacheValue: String?) {
        prefs.edit().putString(cacheKey, cacheValue).apply()
    }

    override fun writeInt(cacheKey: String, cacheValue: Int) {
        prefs.edit().putInt(cacheKey, cacheValue).apply()
    }

    override fun writeFloat(cacheKey: String, cacheValue: Float) {
        prefs.edit().putFloat(cacheKey, cacheValue).apply()
    }

    override fun writeBoolean(cacheKey: String, cacheValue: Boolean) {
        prefs.edit().putBoolean(cacheKey, cacheValue).apply()
    }

    override fun <T> writeObject(cacheKey: String, data: T?) {
        try {
            val oos = ObjectOutputStream(
                FileOutputStream(context.filesDir.absolutePath + cacheKey, false)
            )
            oos.writeObject(data)
            oos.flush()
            oos.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    override fun readStringCache(cacheKey: String): String {
        return prefs.getString(cacheKey, "")!!
    }

    override fun readIntCache(cacheKey: String, defValue: Int): Int {
        return prefs.getInt(cacheKey, 0)
    }

    override fun readFloatCache(cacheKey: String): Float {
        return prefs.getFloat(cacheKey, 0.0f)
    }

    override fun readBooleanCache(cacheKey: String): Boolean {
        return prefs.getBoolean(cacheKey, false)
    }

    override fun <T> readObject(cacheKey: String): T? {
        return try {
            val persistenceFile = File(context.filesDir.absolutePath + cacheKey)
            if (persistenceFile.exists()) {
                val ois = ObjectInputStream(
                    FileInputStream(persistenceFile.absolutePath)
                )
                return ois.readObject() as T
            }
            return null
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    override fun clearCache(cacheKey: String) {
        prefs.edit().remove(cacheKey).apply()
    }

    override fun clearAllCache() {
        prefs.edit().clear().apply()
    }

}