package com.ivanov.tech.viae

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.ivanov.tech.viae.ui.form.Form

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, Form.newInstance())
                .commitNow()
        }
    }

    companion object {
        val MOCK_FORM = """

        """.trimIndent()
    }

}
