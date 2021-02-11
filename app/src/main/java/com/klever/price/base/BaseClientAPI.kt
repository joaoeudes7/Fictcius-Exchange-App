package com.jdeve.mesanews.base

import android.content.Context
import okhttp3.Cache
import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

class BaseClientAPI(val context: Context) {

    companion object {
        private const val cacheSize: Long = 5 * 1024 * 1024 // 10 MB
    }

    private val cache = Cache(context.cacheDir, cacheSize)

    private val logger = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BASIC
    }

    private val client =  OkHttpClient.Builder()
        .cache(cache)
        .addInterceptor(logger)
        .connectTimeout(10, TimeUnit.SECONDS)
        .writeTimeout(10, TimeUnit.SECONDS)
        .readTimeout(20, TimeUnit.SECONDS)
        .build()

    private val retrofit = Retrofit.Builder()
        .client(client)
        .addConverterFactory(MoshiConverterFactory.create())

    fun <T> buildService(baseUrl: String, service: Class<T>): T {
        return retrofit.baseUrl(baseUrl.toHttpUrl()).build().create(service)
    }

}