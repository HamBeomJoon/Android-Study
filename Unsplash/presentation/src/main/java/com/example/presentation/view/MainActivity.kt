package com.example.presentation.view

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.unex.databinding.ActivityMainBinding
import com.example.presentation.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        observer()
        viewModel.fetchData()
    }

    private fun observer() {
        viewModel.uiState.observe(this) {
            when (it) {
                is com.example.presentation.utils.UiState.Failure -> {}
                is com.example.presentation.utils.UiState.Loading -> {}
                is com.example.presentation.utils.UiState.Success -> {
                    Log.d("TAG1", it.toString())
                }
            }
        }
    }
}