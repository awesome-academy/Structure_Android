package com.sun.android.utils.extension

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.sun.android.BuildConfig

fun ImageView.loadImageCircleWithUrl(url: String) {
    Glide.with(this)
        .load(BuildConfig.BASE_URL_IMAGE + url)
        .circleCrop()
        .into(this)
}

fun ImageView.loadImageWithUrl(url: String) {
    Glide.with(this)
        .load(BuildConfig.BASE_URL_IMAGE + url)
        .into(this)
}
