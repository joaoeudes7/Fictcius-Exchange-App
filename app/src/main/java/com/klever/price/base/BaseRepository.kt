package com.jdeve.mesanews.base

import kotlinx.coroutines.withContext
import java.util.*

open class BaseRepository {
    companion object {
        val coroutineProviders = CoroutineProviders()
    }

    suspend fun <T> runInIo(funSuspend: () -> Unit) = withContext(coroutineProviders.io) {
        return@withContext funSuspend.invoke()
    }
}