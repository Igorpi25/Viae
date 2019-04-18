package com.ivanov.tech.viae.ui.form

import android.arch.lifecycle.LiveData
import com.ivanov.tech.viae.increment.Incrementer
import com.ivanov.tech.viae.increment.IntegerIncrementer

class IntegerIncrementerLiveData : LiveData<Int>(), Incrementer<Int> {

    private val incrementer = IntegerIncrementer()

    init {
        value = number
    }

    override fun getNumber(): Int = incrementer.number

    override fun incrementNumber() {
        incrementer.incrementNumber()
        value = number
    }

    override fun setMaximumValue(maximumValue: Int) {
        incrementer.setMaximumValue(maximumValue.toInt())
    }

}