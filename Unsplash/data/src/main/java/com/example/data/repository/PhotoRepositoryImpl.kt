package com.example.data.repository

import android.util.Log
import com.example.data.datasource.PhotoDataSource
import com.example.domain.model.PhotoEntity
import com.example.domain.repository.PhotoRepository
import org.json.JSONObject
import javax.inject.Inject

class PhotoRepositoryImpl @Inject constructor(private val photoDataSource: PhotoDataSource) :
    PhotoRepository {
//    private val service = RetrofitClient.getInstance().create(com.example.data.service.PhotoService::class.java)
    override suspend fun getRandomPhotos(
        clientId: String,
        query: String?
    ): Result<List<PhotoEntity>> {
        val res = service.getRandomPhotos(clientId)
        return if (res.isSuccessful) {
            Log.d("TAG", res.body().toString())
            if (res.body() == null) Result.success(listOf())
            else Result.success(com.example.data.mapper.PhotoMapper.mapperToResponseEntity(res.body()!!))
        } else {
            Log.d("TAG", res.body().toString())
            val errorMsg = JSONObject(res.errorBody()!!.string()).getString("msg")
            Result.failure(java.lang.Exception(errorMsg))
        }
    }
}