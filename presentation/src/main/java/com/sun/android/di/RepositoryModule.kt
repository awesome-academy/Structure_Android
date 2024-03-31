package com.sun.android.di

import com.sun.domain.MovieRepository
import com.sun.domain.TokenRepository
import com.sun.data.repository.MovieRepositoryImpl
import com.sun.data.repository.TokenRepositoryImpl
import com.sun.data.source.MovieDataSource
import com.sun.data.source.TokenDataSource
import org.koin.dsl.module

val RepositoryModule = module {
    single { provideTokenRepository(get()) }

    single { provideMovieRepository(get(), get()) }
}

fun provideTokenRepository(local: com.sun.data.source.TokenDataSource.Local): com.sun.domain.TokenRepository {
    return com.sun.data.repository.TokenRepositoryImpl(local)
}

fun provideMovieRepository(remote: com.sun.data.source.MovieDataSource.Remote, local: com.sun.data.source.MovieDataSource.Local): com.sun.domain.MovieRepository {
    return com.sun.data.repository.MovieRepositoryImpl(remote, local)
}
