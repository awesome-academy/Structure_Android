package com.sun.android.utils.livedata

import androidx.lifecycle.Observer

class SafeObserver<T>(private val notifier: (T) -> Unit) : Observer<T> {
    override fun onChanged(t: T) {
        notifier(t)
    }
}
