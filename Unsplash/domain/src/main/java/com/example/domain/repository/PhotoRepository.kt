package com.example.domain.repository

import com.example.domain.model.PhotoEntity


interface PhotoRepository {
    suspend fun getRandomPhotos(clientId: String, query: String?): Result<List<PhotoEntity>>
}