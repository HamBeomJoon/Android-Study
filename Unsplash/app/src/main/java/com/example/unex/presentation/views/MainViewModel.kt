package com.example.unex.presentation.views

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.unex.BuildConfig
import com.example.unex.data.repository.PhotoRepositoryImpl
import com.example.unex.domain.data.PhotoEntity
import com.example.unex.presentation.utils.UiState
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val photoRepositoryImpl = PhotoRepositoryImpl()
    private val _uiState = MutableLiveData<UiState<List<PhotoEntity>>>(UiState.Loading)
    val uiState: LiveData<UiState<List<PhotoEntity>>> get() = _uiState

    fun fetchData() {
        _uiState.value = UiState.Loading

        viewModelScope.launch {
            val accessToken =
                BuildConfig.UNSPLASH_ACCESS_KEY

            photoRepositoryImpl.getRandomPhotos(accessToken, null)
                .onSuccess {
                    _uiState.value = UiState.Success(it)
                }.onFailure {
                    _uiState.value = UiState.Failure(it.message)
                }
        }
    }
}