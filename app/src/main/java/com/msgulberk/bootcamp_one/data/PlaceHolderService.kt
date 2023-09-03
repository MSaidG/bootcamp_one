package com.msgulberk.bootcamp_one.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.DELETE

interface PlaceHolderApi {
    @GET("users")
    suspend fun getAllUsers() : Response<UserResponse>


}

object PlaceHolderService {

        val baseUrl = "https://jsonplaceholder.typicode.com"

        fun build(): PlaceHolderApi {

            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY

            val okHtppClient = OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build()

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(baseUrl)
                .client(okHtppClient)
                .build()

            return retrofit.create(PlaceHolderApi::class.java)

        }
}