package com.slashmobility.seleccion.ray.pasache

import android.app.Application
import com.slashmobility.seleccion.ray.pasache.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class SlashMobilityTestApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin()
    }

    private fun startKoin() {
        startKoin{
            androidContext(this@SlashMobilityTestApplication)
            modules(listOf(
                    viewModelModule,
                    useCaseModule,
                    repositoryModule,
                    remoteDataSourceModule,
                    localDataSourceModule
            )
            )
        }
    }
}