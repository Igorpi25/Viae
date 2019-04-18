package com.ivanov.tech.viae.ui.form

import android.arch.lifecycle.ViewModel

class FormViewModel : ViewModel() {
    val liveIncrementer = IntegerIncrementerLiveData()
}
