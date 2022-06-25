package com.example.myokashi

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel constructor(private val repository: OkashiRepository = OkashiRepository()) :
    ViewModel() {

    val items = MutableLiveData<List<APIResponse.Item>?>()

    fun searchOkashi(keyword: String) {
        viewModelScope.launch {
            val response = repository.searchOkashi(keyword = keyword)
            items.value = response.item
        }
    }
}