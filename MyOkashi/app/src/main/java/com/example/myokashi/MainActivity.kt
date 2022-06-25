package com.example.myokashi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.viewModels
import androidx.core.widget.doOnTextChanged
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonSearch = findViewById<Button>(R.id.buttonSearch)
        val textInputLayoutKeyword = findViewById<TextInputLayout>(R.id.textInputLayoutKeyword)
        val textInputEditTextKeyword =
            findViewById<TextInputEditText>(R.id.textInputEditTextKeyword)

        buttonSearch.isEnabled = false

        textInputEditTextKeyword.doOnTextChanged { text, start, before, count ->
            val isErrorEnabled = (count == 0)
            buttonSearch.isEnabled = !isErrorEnabled
            textInputLayoutKeyword.isErrorEnabled = isErrorEnabled
            if (isErrorEnabled) {
                textInputLayoutKeyword.error = "未入力です！"
            }
        }

        buttonSearch.setOnClickListener {
            viewModel.searchOkashi("ケーキ")
        }

        viewModel.items.observe(this) {
            it?.forEach {
                Log.d("MainActivity", "name: " + it.name)
            }
        }
    }
}