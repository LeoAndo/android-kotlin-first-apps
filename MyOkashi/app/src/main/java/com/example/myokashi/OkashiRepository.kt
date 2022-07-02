package com.example.myokashi

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface OkashiRepository {
    suspend fun searchOkashi(keyword: String): APIResponse
}

class OkashiRepositoryImpl constructor(
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
    private val apiService: OkashiService = NetworkModule.okashiService
) : OkashiRepository {
    override suspend fun searchOkashi(keyword: String): APIResponse {
        return withContext(dispatcher) {
            apiService.searchOkashi(keyword = keyword)
        }
    }
}