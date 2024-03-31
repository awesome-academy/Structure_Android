package com.sun.android

import android.app.Application
import com.sun.android.di.DataSourceModule
import com.sun.android.di.NetworkModule
import com.sun.android.di.RepositoryModule
import com.sun.android.di.AppModule
import com.sun.android.di.ViewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.core.context.startKoin

class AndroidApplication : Application() {

    private val rootModule = listOf(AppModule, NetworkModule, DataSourceModule, RepositoryModule, ViewModelModule)

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@AndroidApplication)
            androidFileProperties()
            modules(rootModule)
        }
    }
}
