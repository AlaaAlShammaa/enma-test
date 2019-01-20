package com.test.enmatest.util

import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide

internal fun ImageView.loadImage(url: String) {
    Glide.with(this.context)
        .asBitmap()
        .load(url)
        .into(this)
}

internal fun ImageView.loadImage(@DrawableRes drawableId: Int) {
    Glide.with(this.context)
        .load(drawableId)
        .into(this)
}

internal fun ImageView.changeColorTo(colorId: Int) {
    setColorFilter(ContextCompat.getColor(this.context, colorId))
}
