package com.jdeve.mesanews.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

open class BaseFragment<T : ViewBinding>(private val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> T) : Fragment() {
    private var _binding: T? = null
    protected val binding: T
        get() = _binding!!


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = bindingInflater.invoke(inflater, container, false)

        return  binding.root
    }

    protected fun disableBackPress() {
        requireActivity().onBackPressedDispatcher.addCallback(this) {
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}