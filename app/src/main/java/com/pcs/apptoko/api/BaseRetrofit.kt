package com.pcs.apptoko.api

import okhttp3.Interceptor
import okhttp3.OkHttp
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class BaseRetrofit {
    val endpoint : ApiEndpoint

    get() {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

 //localhost diganti ip komputer 192.168.43.174 -> masuk ke cmd ketik ipconfig cari IPv4

        val retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.43.174/pcs/ci-pcs/index.php/api_pcs/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(ApiEndpoint::class.java)
    }
}