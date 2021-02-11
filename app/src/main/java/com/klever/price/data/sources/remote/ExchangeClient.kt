package com.klever.price.data.sources.remote

import com.klever.price.BuildConfig
import io.grpc.ManagedChannel
import io.grpc.internal.ManagedClientTransport
import io.grpc.okhttp.OkHttpChannelBuilder
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.asExecutor

interface ExchangeClient : ManagedClientTransport {
    companion object {
        var INSTANCE: ManagedChannel? = null

        @Synchronized
        fun create(executeIn: CoroutineDispatcher = Dispatchers.IO): ManagedChannel {
            if (INSTANCE == null) {
                INSTANCE = OkHttpChannelBuilder
                    .forAddress(BuildConfig.ENDPOINT, BuildConfig.PORT)
                    .usePlaintext()
                    .executor(executeIn.asExecutor())
                    .build()
            }

            return INSTANCE!!
        }

        @Synchronized
        fun cleanInstance() {
            INSTANCE?.shutdown()
        }
    }
}