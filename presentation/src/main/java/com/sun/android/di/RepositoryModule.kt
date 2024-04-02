package com.sun.android.di

import com.sun.data.repository.MovieRepositoryImpl
import com.sun.data.repository.TokenRepositoryImpl
import com.sun.data.source.MovieDataSource
import com.sun.domain.repository.MovieRepository
import com.sun.domain.repository.TokenRepository
import org.koin.dsl.module

val RepositoryModule = module {
    single { provideTokenRepository(get()) }

    single { provideMovieRepository(get(), get()) }
}

fun provideTokenRepository(local: com.sun.data.source.TokenDataSource.Local): TokenRepository {
    return TokenRepositoryImpl(local)
}

fun provideMovieRepository(remote: MovieDataSource.Remote, local: MovieDataSource.Local): MovieRepository {
    return MovieRepositoryImpl(remote, local)
}
