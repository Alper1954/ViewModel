package com.example.viewmodel.ui.main

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val usd_to_eu_rate = 0.74f

    private var _result: Float = 0f
    val result: Float
        get() = _result

    fun setAmount(value: String) {
        _result = value.toFloat() * usd_to_eu_rate
    }
}