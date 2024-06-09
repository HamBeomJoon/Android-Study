package com.example.unex.data


import com.google.gson.annotations.SerializedName

data class PhotoResponseDTO(
    @SerializedName("blur_hash")
    val blurHash: String,
    @SerializedName("color")
    val color: String,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("downloads")
    val downloads: Int,
    @SerializedName("exif")
    val exif: Exif,
    @SerializedName("height")
    val height: Int,
    @SerializedName("id")
    val id: String,
    @SerializedName("liked_by_user")
    val likedByUser: Boolean,
    @SerializedName("likes")
    val likes: Int,
    @SerializedName("location")
    val location: Location,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("width")
    val width: Int
) {
    data class Exif(
        @SerializedName("aperture")
        val aperture: String,
        @SerializedName("exposure_time")
        val exposureTime: String,
        @SerializedName("focal_length")
        val focalLength: String,
        @SerializedName("iso")
        val iso: Int,
        @SerializedName("make")
        val make: String,
        @SerializedName("model")
        val model: String
    )

    data class Location(
        @SerializedName("city")
        val city: String,
        @SerializedName("country")
        val country: String,
        @SerializedName("name")
        val name: String,
        @SerializedName("position")
        val position: Position
    ) {
        data class Position(
            @SerializedName("latitude")
            val latitude: Double,
            @SerializedName("longitude")
            val longitude: Double
        )
    }
}