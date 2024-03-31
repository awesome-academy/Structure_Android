package com.sun.android.utils.dispatchers

import androidx.annotation.NonNull
import kotlinx.coroutines.CoroutineDispatcher

interface BaseDispatcherProvider {

    @NonNull
    fun computation(): CoroutineDispatcher

    @NonNull
    fun io(): CoroutineDispatcher

    @NonNull
    fun ui(): CoroutineDispatcher

    @NonNull
    fun unconfined(): CoroutineDispatcher
}
