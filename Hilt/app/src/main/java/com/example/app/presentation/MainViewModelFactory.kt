package com.example.app.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.app.presentation.viewmodel.MainViewModel

class MainViewModelFactory(private val startingTotal: Int) : ViewModelProvider.Factory {

    // ViewModelProvider.Factory를 확장함.
    // 오버라이드 하면 아래와 같은 create 함수를 받을 수 있음.
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        // modelClass에 MainActivityViewModel이 상속이 되었나요? 라고 물어봅니다.
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            // 맞다면 MainViewModel의 파라미터 값을 넘겨주죠.
            return MainViewModel(startingTotal = startingTotal) as T
        }
        // 상속이 되지 않았다면 IllegalArgumentException을 통해 상속이 되지 않았다는 에러를 띄웁니다.
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}
