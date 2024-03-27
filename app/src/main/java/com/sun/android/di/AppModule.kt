package com.sun.android.di

import android.app.Application
import android.content.res.Resources
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.sun.android.data.source.local.api.SharedPrefsApi
import com.sun.android.data.source.local.api.sharedpref.SharedPrefsImpl
import com.sun.android.data.source.local.room.AppDatabase
import com.sun.android.data.source.local.room.MovieDao
import com.sun.android.data.source.remote.api.middleware.BooleanAdapter
import com.sun.android.data.source.remote.api.middleware.DoubleAdapter
import com.sun.android.data.source.remote.api.middleware.IntegerAdapter
import com.sun.android.utils.DateTimeUtils
import com.sun.android.utils.dispatchers.BaseDispatcherProvider
import com.sun.android.utils.dispatchers.DispatcherProvider
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
    val booleanAdapter = BooleanAdapter()
    val integerAdapter = IntegerAdapter()
    val doubleAdapter = DoubleAdapter()
    return GsonBuilder()
        .registerTypeAdapter(Boolean::class.java, booleanAdapter)
        .registerTypeAdapter(Int::class.java, integerAdapter)
        .registerTypeAdapter(Double::class.java, doubleAdapter)
        .setDateFormat(DateTimeUtils.DATE_TIME_FORMAT_UTC)
        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        .excludeFieldsWithoutExposeAnnotation()
        .create()
}

fun provideDatabase(app: Application): AppDatabase {
    return AppDatabase.getDatabase(app.applicationContext)
}

fun provideMovieDao(database: AppDatabase): MovieDao {
    return database.movieDao()
}
