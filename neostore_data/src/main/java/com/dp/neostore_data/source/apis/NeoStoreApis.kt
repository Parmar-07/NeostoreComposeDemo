package com.dp.neostore_data.source.apis

import android.content.Context
import com.dp.neostore_data.source.models.response.*
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.*
import java.util.concurrent.TimeUnit

interface NeoStoreApis {

    @FormUrlEncoded
    @POST("{path}")
    suspend fun login(
        @Path(value = "path", encoded = true) path: String,
        @Field("email") email: String,
        @Field("password") password: String,
    ): Response<ApiResponseModel<LoginResponseModel>>

    @FormUrlEncoded
    @POST("{path}")
    suspend fun updateAccount(
        @Path(value = "path", encoded = true) path: String,
        @Header("access_token") access_token: String,
        @Field("first_name") firstName: String,
        @Field("last_name") lastName: String,
        @Field("email") email: String,
        @Field("dob") dob: String,
        @Field("phone_no") phone_no: String,
        @Field("profile_pic") profile_pic: String,

        ): Response<ApiResponseModel<UpdateProfileResponseModel>>

    @FormUrlEncoded
    @POST("{path}")
    suspend fun register(
        @Path(value = "path", encoded = true) path: String,
        @Field("first_name") first_name: String,
        @Field("last_name") last_name: String,
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("confirm_password") confirm_password: String,
        @Field("gender") gender: String,
        @Field("phone_no") phone_no: Number,
    ): Response<ApiResponseModel<RegisterResponseModel>>

    @FormUrlEncoded
    @POST("{path}")
    suspend fun forgotPassword(
        @Path(value = "path", encoded = true) path: String,
        @Field("email") email: String,
    ): Response<ApiResponseModel<Nothing>>


    @FormUrlEncoded
    @POST("{path}")
    suspend fun changePassword(
        @Path(value = "path", encoded = true) path: String,
        @Field("old_password") old_password: String,
        @Field("old_password") password: String,
        @Field("old_password") confirm_password: String,
    ): Response<ApiResponseModel<Nothing>>


    @GET("{path}")
    suspend fun getUserData(
        @Path(value = "path", encoded = true) path: String,
        @Header("access_token") access_token: String,
    ): Response<ApiResponseModel<ProfileUserResponseModel>>

    @GET("{path}")
    suspend fun getProducts(
        @Path(value = "path", encoded = true) path: String,
        @Query("product_category_id") categoryId: String,
    ): Response<ApiResponseListModel<GetProductsResponseModel>>

    @GET("{path}")
    suspend fun getProductDetail(
        @Path(value = "path", encoded = true) path: String,
        @Query("product_id") product_id: String,
    ): Response<ApiResponseModel<GetProductDetailResponseModel>>

    @FormUrlEncoded
    @POST("{path}")
    suspend fun addToCart(
        @Path(value = "path", encoded = true) path: String,
        @Header("access_token") access_token: String,
        @Field("product_id") product_id: Int,
        @Field("quantity") quantity: Int,

        ): Response<ApiResponseModel<Boolean>>

    companion object {
        private var retrofit: Retrofit? = null

        fun invoke(baseUrl: String, context: Context): NeoStoreApis {

            val httpLogging = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(httpLogging)
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .build()

            if (retrofit == null) {
                val gson = GsonBuilder().setLenient()
                    .create()
                retrofit = Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(okHttpClient)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build()
            }

            return retrofit!!.create(NeoStoreApis::class.java)


        }


    }

}