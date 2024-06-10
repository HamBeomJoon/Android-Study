package com.example.unex.data

import com.example.unex.data.model.PhotoResponseDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PhotoService {
    @GET("photos/random")
    suspend fun getRandomPhotos(
        @Query("client_id") clientId: String,
        @Query("count") count: Int = 30,
        @Query("query") query: String? = null
    ): Response<List<PhotoResponseDTO>>
}