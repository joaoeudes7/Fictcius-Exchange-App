package com.jdeve.mesanews.utils

import android.widget.ImageView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.klever.price.utils.GenericDiff
import java.text.SimpleDateFormat
import java.util.*

// Util to simplify the use of AsyncListDiffer
// https://developer.android.com/reference/kotlin/androidx/recyclerview/widget/AsyncListDiffer
fun <T> RecyclerView.Adapter<*>.asyncListDifferOf(compare: (new: T, old: T) -> Boolean): AsyncListDiffer<T> {
    return AsyncListDiffer(this, GenericDiff<T>(compare))
}

fun ImageView.loadImage(url: String?) {
    Glide.with(context)
        .load(url)
        .centerCrop()
        .into(this)
}

/**
 * Format date to yyyy-MM-dd
 */
fun Date.toISO8601(): String {
    return SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(this)
}