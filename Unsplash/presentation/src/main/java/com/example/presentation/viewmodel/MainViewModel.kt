package com.example.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.unex.BuildConfig
import com.example.data.repository.PhotoRepositoryImpl
import com.example.domain.model.PhotoEntity
import com.example.presentation.utils.UiState
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val photoRepositoryImpl = com.example.data.repository.PhotoRepositoryImpl()
    private val _uiState = MutableLiveData<com.example.presentation.utils.UiState<List<com.example.domain.model.PhotoEntity>>>(
        com.example.presentation.utils.UiState.Loading)
    val uiState: LiveData<com.example.presentation.utils.UiState<List<com.example.domain.model.PhotoEntity>>> get() = _uiState

    fun fetchData() {
        _uiState.value = com.example.presentation.utils.UiState.Loading

        viewModelScope.launch {
            val accessToken =
                BuildConfig.UNSPLASH_ACCESS_KEY

            photoRepositoryImpl.getRandomPhotos(accessToken, null)
                .onSuccess {
                    _uiState.value = com.example.presentation.utils.UiState.Success(it)
                }.onFailure {
                    _uiState.value = com.example.presentation.utils.UiState.Failure(it.message)
                }
        }
    }
}