package com.klever.price

import androidx.multidex.MultiDexApplication
import com.klever.price.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

@Suppress("unused")
class KleverApp : MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@KleverApp)
            modules(listOf(
                networkModule,
                localModule,
                repositoriesModule,
                useCasesModule,
                viewModelModule,
            ))
        }

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}