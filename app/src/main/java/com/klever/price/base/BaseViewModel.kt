package com.klever.price.base

import androidx.lifecycle.ViewModel
import com.klever.price.data.sources.remote.ExchangeClient

open class BaseViewModel : ViewModel() {

    override fun onCleared() {
        super.onCleared()

        ExchangeClient.cleanInstance()
    }
}