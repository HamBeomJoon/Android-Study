package com.example.unex.data.repository

import android.util.Log
import com.example.unex.data.mapper.PhotoMapper
import com.example.unex.data.remote.api.PhotoService
import com.example.unex.data.remote.RetrofitClient
import com.example.unex.domain.data.PhotoEntity
import com.example.unex.domain.repository.PhotoRepository
import org.json.JSONObject

class PhotoRepositoryImpl : PhotoRepository {
    private val service = RetrofitClient.getInstance().create(PhotoService::class.java)

    override suspend fun getRandomPhotos(
        clientId: String,
        query: String?
    ): Result<List<PhotoEntity>> {
        val res = service.getRandomPhotos(clientId)
        return if (res.isSuccessful) {
            Log.d("TAG", res.body().toString())
            if (res.body() == null) Result.success(listOf())
            else Result.success(PhotoMapper.mapperToResponseEntity(res.body()!!))
        } else {
            Log.d("TAG", res.body().toString())
            val errorMsg = JSONObject(res.errorBody()!!.string()).getString("msg")
            Result.failure(java.lang.Exception(errorMsg))
        }
    }
}