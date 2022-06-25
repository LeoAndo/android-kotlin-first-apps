package com.example.myokashi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.viewModels
import androidx.core.widget.doOnTextChanged
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    private val viewModel by viewModels<MainViewModel>()
    private val okashiListAdapter = OkashiListAdapter(onItemClick = {
        // TODO ブラウザを起動する処理を入れる.
        AppLaunchHelper(this).launchBrowserApp(it.url)
    })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonSearch = findViewById<Button>(R.id.buttonSearch)
        val textInputLayoutKeyword = findViewById<TextInputLayout>(R.id.textInputLayoutKeyword)
        val textInputEditTextKeyword =
            findViewById<TextInputEditText>(R.id.textInputEditTextKeyword)

        buttonSearch.isEnabled = false

        textInputEditTextKeyword.doOnTextChanged { text, start, before, count ->
            val isErrorEnabled = text.isNullOrEmpty()
            buttonSearch.isEnabled = !isErrorEnabled
            textInputLayoutKeyword.isErrorEnabled = isErrorEnabled
            if (isErrorEnabled) {
                textInputLayoutKeyword.error = "未入力です！"
            }
        }

        buttonSearch.setOnClickListener {
            val keyword = textInputEditTextKeyword.text.toString()
            viewModel.searchOkashi(keyword)
        }

        viewModel.items.observe(this) {
            it?.forEach {
                Log.d("MainActivity", "name: " + it.name)
            }
            okashiListAdapter.submitList(it)
        }

        val okashiList = findViewById<RecyclerView>(R.id.okashiList)
        okashiList.adapter = okashiListAdapter
        okashiList.layoutManager = LinearLayoutManager(this)
    }
}