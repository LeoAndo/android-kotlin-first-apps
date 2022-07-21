package com.example.myokashi

import com.example.myokashi.domain.OkashiDomainModel

sealed class UiState {
    object Initial : UiState()
    object Loading : UiState()
    data class Success(val items: List<OkashiDomainModel>?) : UiState()
    data class Error(val errorMessage: String) : UiState()
}