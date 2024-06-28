package com.example.app

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class MockViewModel {
    val totalCount get() = list.value?.sumOf { it.itemCount } ?: 0

    private val _list = MutableLiveData<List<ItemData>>(DummyItemData)
    val list: LiveData<List<ItemData>> get() = _list

    fun updateItemCount(position: Int, itemCount: Int) {
        val newList = _list.value
        if (newList != null) {
            newList.getOrNull(position)?.itemCount = itemCount
            _list.postValue(newList)
        }
    }

    fun updateItem(position: Int, itemData: ItemData) {
        _list.value?.let { list ->
            val newList = list.toMutableList().apply { add(itemData) }
            _list.postValue(newList)
        }
    }
}