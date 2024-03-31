package com.sun.android.di

import android.app.Application
import com.google.gson.Gson
import com.sun.android.BuildConfig
import com.sun.domain.TokenRepository
import com.sun.data.source.remote.api.ApiService
import com.sun.data.source.remote.api.middleware.InterceptorImpl
import java.util.concurrent.TimeUnit
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val NetworkModule = module {
    single { provideOkHttpCache(get()) }

    single { provideOkHttpClient(get(), get()) }

    single { provideInterceptor(get()) }

    single { provideRetrofit(get(), get()) }

    single { provideApiService(get()) }
}

fun provideOkHttpCache(app: Application): Cache {
    val cacheSize: Long = NetWorkInstant.CACHE_SIZE
    return Cache(app.cacheDir, cacheSize)
}

fun provideInterceptor(tokenRepository: com.sun.domain.TokenRepository): Interceptor {
    return com.sun.data.source.remote.api.middleware.InterceptorImpl(tokenRepository)
}

fun provideOkHttpClient(cache: Cache, interceptor: Interceptor): OkHttpClient {
    val httpClientBuilder = OkHttpClient.Builder()
    httpClientBuilder.cache(cache)
    httpClientBuilder.addInterceptor(interceptor)

    httpClientBuilder.readTimeout(
        NetWorkInstant.READ_TIMEOUT,
        TimeUnit.SECONDS
    )
    httpClientBuilder.writeTimeout(
        NetWorkInstant.WRITE_TIMEOUT,
        TimeUnit.SECONDS
    )
    httpClientBuilder.connectTimeout(
        NetWorkInstant.CONNECT_TIMEOUT,
        TimeUnit.SECONDS
    )

    if (BuildConfig.DEBUG) {
        val logging = HttpLoggingInterceptor()
        httpClientBuilder.addInterceptor(logging)
        logging.level = HttpLoggingInterceptor.Level.BODY
    }

    return httpClientBuilder.build()
}

fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder().baseUrl(BuildConfig.BASE_URL).addConverterFactory(GsonConverterFactory.create(gson))
        .client(okHttpClient).build()
}

fun provideApiService(retrofit: Retrofit): com.sun.data.source.remote.api.ApiService {
    return retrofit.create(com.sun.data.source.remote.api.ApiService::class.java)
}

object NetWorkInstant {
    internal const val READ_TIMEOUT = 60L
    internal const val WRITE_TIMEOUT = 30L
    internal const val CONNECT_TIMEOUT = 60L

    internal const val CACHE_SIZE = 10 * 1024 * 1024L // 10MB
}
