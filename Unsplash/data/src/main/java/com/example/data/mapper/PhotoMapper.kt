package com.example.data.mapper

import com.example.data.model.ResponsePhotoDTO
import com.example.domain.model.PhotoEntity


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