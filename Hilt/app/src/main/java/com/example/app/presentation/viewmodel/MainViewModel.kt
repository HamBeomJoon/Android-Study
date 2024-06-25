package com.example.app.presentation.viewmodel

import androidx.lifecycle.ViewModel

class MainViewModel(startingTotal: Int) : ViewModel() {

    private var total = 0

    // init을 통해 startingTotal을 total로 할당
    init {
        total = startingTotal
    }

    // 결과값을 return 하는 함수
    fun getTotal(): Int {
        return total
    }

    // 숫자를 더할 때 사용할 함수
    fun setTotal(input: Int) {
        total += input
    }

}