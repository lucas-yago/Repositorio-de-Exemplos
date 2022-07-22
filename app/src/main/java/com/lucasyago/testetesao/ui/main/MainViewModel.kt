package com.lucasyago.testetesao.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var count = MutableLiveData<Int>()
    val num = Transformations.map(count) { it.toString() }

    init {
        count.value = 0
    }

    fun sumMoreOne() {
        count.value = count.value?.plus(1)
    }

    fun minusMoreOne() {
        count.value = count.value?.minus(1)
    }
}