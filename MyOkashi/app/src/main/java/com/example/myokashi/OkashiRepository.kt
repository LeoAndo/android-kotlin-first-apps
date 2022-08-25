package com.example.myokashi

import com.example.myokashi.domain.OkashiDomainModel
import com.example.myokashi.domain.toOkashiDomainModels
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class OkashiRepository constructor(
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
    private val apiService: OkashiService = NetworkModule.okashiService
) {
    suspend fun searchOkashi(keyword: String): List<OkashiDomainModel>? {
        return withContext(dispatcher) {
            apiService.searchOkashi(keyword = keyword).toOkashiDomainModels()
        }
    }
}