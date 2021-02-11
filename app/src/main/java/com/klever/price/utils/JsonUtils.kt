package com.klever.price.utils

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

val moshi = Moshi.Builder()
    .addLast(KotlinJsonAdapterFactory())
    .build()

fun <T> fromJson(json: String, kClass: Class<T>): T? {
    return moshi.adapter(kClass).fromJson(json)
}

inline fun <reified T> toJson(obj: T): String {
    return moshi.adapter(T::class.java).toJson(obj)
}