package com.klever.price.di

import com.klever.price.data.repository.MarketRepositoryImpl
import com.klever.price.data.repository.WalletRepositoryImpl
import com.klever.price.data.sources.remote.ExchangeClient
import com.klever.price.domain.repository.MarketRepository
import com.klever.price.domain.repository.WalletRepository
import com.klever.price.domain.useCases.*
import com.klever.price.ui.sharedViewModels.MarketViewModel
import com.klever.price.ui.sharedViewModels.WalletViewModel
import org.koin.dsl.module

val networkModule = module {
    single { ExchangeClient.create() }
}

val localModule = module {
}

val repositoriesModule = module {
    single<MarketRepository> { MarketRepositoryImpl() }
    single<WalletRepository> { WalletRepositoryImpl() }
}

val useCasesModule = module {
    single { BuyUseCase(get()) }
    single { SellUseCase(get()) }
    single { GetCoinsUseCase(get()) }
    single { GetOrdersUseCase(get()) }
    single { GetPairsMarketUseCase(get()) }
    single { GetWalletUseCase(get()) }
}

val viewModelModule = module {
    single { MarketViewModel(get(), get(), get()) }
    single { WalletViewModel(get()) }
}
