package com.iftah.movieapp

import android.app.Application
import com.iftah.core.di.databaseModule
import com.iftah.core.di.networkModule
import com.iftah.core.di.repositoryModule
import com.iftah.movieapp.di.useCaseModule
import com.iftah.movieapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level


class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}