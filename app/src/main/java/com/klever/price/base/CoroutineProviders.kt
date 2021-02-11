package com.jdeve.mesanews.base

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class CoroutineProviders(
    val io: CoroutineDispatcher = Dispatchers.IO,
    val main: CoroutineDispatcher = Dispatchers.Main,
    val cpu: CoroutineDispatcher = Dispatchers.Default,
) {
}