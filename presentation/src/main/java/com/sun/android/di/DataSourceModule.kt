package com.sun.android.di

import com.sun.data.source.MovieDataSource
import com.sun.data.source.TokenDataSource
import com.sun.data.source.local.MovieLocalImpl
import com.sun.data.source.local.TokenLocalImpl
import com.sun.data.source.remote.MovieRemoteImpl
import org.koin.dsl.module

val DataSourceModule = module {
    single<com.sun.data.source.TokenDataSource.Local> { com.sun.data.source.local.TokenLocalImpl(get()) }

    single<com.sun.data.source.MovieDataSource.Remote> {
        com.sun.data.source.remote.MovieRemoteImpl(
            get()
        )
    }

    single<com.sun.data.source.MovieDataSource.Local> { com.sun.data.source.local.MovieLocalImpl(get()) }
}
