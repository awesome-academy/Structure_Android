package com.sun.android.utils

import android.util.Log
import com.sun.android.BuildConfig

object LogUtils {

    private val DEBUG = BuildConfig.DEBUG

    fun d(tag: String, message: String) {
        if (DEBUG) {
            Log.d(tag, message)
        }
    }

    fun e(tag: String, msg: String) {
        if (DEBUG) {
            Log.e(tag, msg)
        }
    }

    fun e(tag: String, msg: String, throwable: Throwable) {
        if (DEBUG) {
            Log.e(tag, msg, throwable)
        }
    }

    fun thread() {
        if (DEBUG) {
            Log.e("THREAD", "${Thread.currentThread().name} has run.")
        }
    }
}
