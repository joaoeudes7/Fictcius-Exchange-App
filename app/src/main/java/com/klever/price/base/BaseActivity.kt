package com.jdeve.mesanews.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<T : ViewBinding>(private val bindingInflater: (LayoutInflater) -> T) : AppCompatActivity() {
    private var _binding: T? = null
    protected val binding: T
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = bindingInflater(layoutInflater)

        setContentView(binding.root)

        onViewCreated()
    }

    abstract fun onViewCreated()

    override fun onDestroy() {
        super.onDestroy()

        _binding = null
    }
}