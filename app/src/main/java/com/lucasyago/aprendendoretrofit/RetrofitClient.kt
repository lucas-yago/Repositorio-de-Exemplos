package com.lucasyago.aprendendoretrofit

import com.lucasyago.aprendendoretrofit.services.PostServices
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    companion object {
        private lateinit var INSTANCE: Retrofit
        private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

        private fun getRetrofitClient(): Retrofit {
            val http = OkHttpClient.Builder()
            if (!::INSTANCE.isInitialized) {
                INSTANCE = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(http.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return INSTANCE
        }

        fun <T> createService(serviceClass: Class<T>): T{
            return getRetrofitClient().create(serviceClass)
        }
    }
}