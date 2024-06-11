package com.example.unex.domain.repository

import com.example.unex.domain.data.PhotoEntity


interface PhotoRepository {
    suspend fun getRandomPhotos(clientId: String, query: String?): Result<List<PhotoEntity>>
}