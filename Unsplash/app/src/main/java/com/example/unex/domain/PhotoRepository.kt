package com.example.unex.domain

interface PhotoRepository {
    suspend fun getRandomPhotos(clientId: String, query: String?): Result<List<PhotoEntity>>
}