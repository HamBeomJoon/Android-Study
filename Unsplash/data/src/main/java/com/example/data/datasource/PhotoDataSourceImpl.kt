package com.example.data.datasource

import android.util.Log
import com.example.data.model.ResponsePhotoDTO
import com.example.data.service.PhotoService
import org.json.JSONObject
import javax.inject.Inject

class PhotoDataSourceImpl @Inject constructor(private val photoService: PhotoService) :
    PhotoDataSource {
    override suspend fun getRandomPhotos(clientId: String, query: String?):List<ResponsePhotoDTO> {
        val res = photoService.getRandomPhotos(clientId)
        return res.body()!!
//        return if (res.isSuccessful) {
//            Log.d("TAG", res.body().toString())
//            res.body()
//        } else {
//            Log.d("TAG", res.body().toString())
//            val errorMsg = JSONObject(res.errorBody()!!.string()).getString("msg")
//
//        }
    }

}