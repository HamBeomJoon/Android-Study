package com.example.data.datasource

import com.example.data.model.ResponsePhotoDTO

interface PhotoDataSource {
    suspend fun getRandomPhotos(clientId: String, query: String?): List<ResponsePhotoDTO>
}