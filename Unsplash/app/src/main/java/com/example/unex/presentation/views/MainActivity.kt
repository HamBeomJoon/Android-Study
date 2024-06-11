package com.example.unex.presentation.views

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.unex.databinding.ActivityMainBinding
import com.example.unex.presentation.utils.UiState

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
                is UiState.Failure -> {}
                is UiState.Loading -> {}
                is UiState.Success -> {
                    Log.d("TAG", it.toString())
                }
            }
        }
    }
}