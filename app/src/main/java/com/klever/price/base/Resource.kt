package com.jdeve.mesanews.base

import timber.log.Timber

class Resource<T>(
    val state: StateResult,
    val data: T? = null,
    val exception: Throwable? = null
) {
    enum class StateResult {
        LOADING,
        SUCCESS,
        FAILURE
    }

    companion object {
        fun <T> loading(): Resource<T> {
            return Resource(StateResult.LOADING)
        }

        fun <T> success(data: T): Resource<T> {
            return Resource(StateResult.SUCCESS, data)
        }

        fun <T> failure(e: Throwable): Resource<T> {
            Timber.e(e)

            return Resource(StateResult.FAILURE,null, e)
        }
    }
}