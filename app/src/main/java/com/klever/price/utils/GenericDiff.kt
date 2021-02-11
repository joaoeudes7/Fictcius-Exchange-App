package com.klever.price.utils

import androidx.recyclerview.widget.DiffUtil
import java.util.*

open class GenericDiff<T>(val compare: (new: T, old: T) -> Boolean): DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return compare(oldItem, newItem)
    }

    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return Objects.equals(oldItem, newItem)
    }
}