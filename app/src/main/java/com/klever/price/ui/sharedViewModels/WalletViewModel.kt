package com.klever.price.ui.sharedViewModels

import androidx.lifecycle.asLiveData
import com.klever.price.base.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import com.klever.price.domain.entities.WalletCoinModel
import com.klever.price.domain.useCases.GetWalletUseCase
import kotlinx.coroutines.flow.Flow

class WalletViewModel(
    private val getWalletUseCase: GetWalletUseCase,
) : BaseViewModel() {
    private val _wallet = MutableStateFlow(listOf<WalletCoinModel>())

    val wallet = _wallet.asLiveData()

    fun fetchWallet(): Flow<List<WalletCoinModel>> {
        return getWalletUseCase()
    }

}