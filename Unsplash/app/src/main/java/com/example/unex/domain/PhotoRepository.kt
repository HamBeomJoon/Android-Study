package com.example.unex.domain

import com.example.unex.data.PhotoResponseDTO
import com.example.unex.data.PhotoService

class PhotoRepository {
    private lateinit var service: PhotoService
    suspend fun getRandomPhotos(): List<PhotoResponseDTO>? {
        val response = service.getRandomPhotos(BuildConfig.UNSPLASH_ACCESS_KEY)
        return if (response.isSuccessful) response.body() else null
    }
}