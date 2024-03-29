package com.ivanov.tech.viae.ui.form

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ivanov.tech.viae.R
import kotlinx.android.synthetic.main.form_fragment.*

class Form : Fragment() {

    companion object {
        fun newInstance() = Form()
    }

    private lateinit var viewModel: FormViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.form_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(FormViewModel::class.java)

        val incrementerObserver = Observer<Int> { number ->
            message.text = number.toString()
        }

        viewModel.liveIncrementer.observe(this, incrementerObserver)

        button.setOnClickListener {
            viewModel.liveIncrementer.incrementNumber()
        }

    }

}
