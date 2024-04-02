package com.sun.android.di

import android.app.Application
import android.content.res.Resources
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.sun.android.utils.DateTimeUtils
import com.sun.android.utils.dispatchers.BaseDispatcherProvider
import com.sun.android.utils.dispatchers.DispatcherProvider
import com.sun.data.source.local.api.SharedPrefsApi
import com.sun.data.source.local.api.sharedpref.SharedPrefsImpl
import org.koin.dsl.module

val AppModule = module {
    single { provideResources(get()) }

    single { provideSharedPrefsApi(get(), get()) }

    single { provideBaseDispatcherProvider() }

    single { provideGson() }

    single { provideDatabase(get()) }

    single { provideMovieDao(get()) }
}

fun provideResources(app: Application): Resources {
    return app.resources
}

fun provideSharedPrefsApi(app: Application, gson: Gson): SharedPrefsApi {
    return SharedPrefsImpl(app, gson)
}

fun provideBaseDispatcherProvider(): BaseDispatcherProvider {
    return DispatcherProvider()
}

fun provideGson(): Gson {
    val booleanAdapter = com.sun.data.source.remote.api.middleware.BooleanAdapter()
    val integerAdapter = com.sun.data.source.remote.api.middleware.IntegerAdapter()
    val doubleAdapter = com.sun.data.source.remote.api.middleware.DoubleAdapter()
    return GsonBuilder()
        .registerTypeAdapter(Boolean::class.java, booleanAdapter)
        .registerTypeAdapter(Int::class.java, integerAdapter)
        .registerTypeAdapter(Double::class.java, doubleAdapter)
        .setDateFormat(DateTimeUtils.DATE_TIME_FORMAT_UTC)
        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        .excludeFieldsWithoutExposeAnnotation()
        .create()
}

fun provideDatabase(app: Application): com.sun.data.source.local.room.AppDatabase {
    return com.sun.data.source.local.room.AppDatabase.getDatabase(app.applicationContext)
}

fun provideMovieDao(database: com.sun.data.source.local.room.AppDatabase): com.sun.data.source.local.room.MovieDao {
    return database.movieDao()
}
