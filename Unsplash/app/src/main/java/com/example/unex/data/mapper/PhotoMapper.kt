package com.example.unex.data.mapper

import com.example.unex.data.model.ResponsePhotoDTO
import com.example.unex.domain.data.PhotoEntity

object PhotoMapper {
    fun mapperToResponseEntity(item: List<ResponsePhotoDTO>): List<PhotoEntity> {
        val photoList = mutableListOf<PhotoEntity>()
        item.run {
            this.forEach {
                photoList.add(PhotoEntity(it.urls.thumb))
            }
        }
        return photoList
    }
}