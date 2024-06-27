package com.example.app

data class ItemData(
    val no: Int,
    val name: String,
    val type: String,
    val description: String,
    val imageUrl: String,
    val itemCount: Int = 0
)

val DummyItemData = arrayListOf(
    ItemData(1, "name", "type", "description", "imageUrl"),
    ItemData(2, "name", "type", "description", "imageUrl"),
    ItemData(3, "name", "type", "description", "imageUrl"),
    ItemData(4, "name", "type", "description", "imageUrl")
)