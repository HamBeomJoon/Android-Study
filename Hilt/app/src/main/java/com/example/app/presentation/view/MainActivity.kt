package com.example.app.presentation.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.app.R
import com.example.app.databinding.ActivityMainBinding
import com.example.app.presentation.MainViewModelFactory
import com.example.app.presentation.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    // 나중에 정의한 변수들을 lateinit var로 선언
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var viewModelFactory: MainViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // databinding 적용.
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        // 시작 값을 100으로 지정
        viewModelFactory = MainViewModelFactory(startingTotal = 100)
        // viewModel의 주최를 MainActivityViewModel, owner에 viewModelFactory도 추가
        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]

        // getTotal()를 호출해 현재 total(현재 값 : 0)을 불러온다.
        binding.tvSum.text = viewModel.getTotal().toString()

        binding.btnCount.setOnClickListener {
            // setTotal()을 호출해 edittext의 값을 total에 더한다.
            viewModel.setTotal(binding.etCount.text.toString().toInt())
            // 현재 값을 불러온다.
            binding.tvSum.text = viewModel.getTotal().toString()
        }
    }
}