package com.example.app

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.app.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var myAdapter: MyAdapter
    private val mainViewModel: MockViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupRecyclerView()
        setupAddButton()
    }

    private fun setupRecyclerView() {
        myAdapter = MyAdapter(mainViewModel)
        binding.rvMain.adapter = myAdapter

        // 리스너 설정
        myAdapter.setClickListener { itemData ->
            // ivPlus 클릭 시 처리할 로직
            // 예: 아이템 수량 증가
            mainViewModel.updateItemCount(itemData.no - 1, itemData.itemCount + 1)
        }
    }

    private fun setupAddButton() {
        binding.addButton.setOnClickListener {
            val newItem = DummyItemData[Random.nextInt(0, 3)].copy(
                no = myAdapter.itemCount + 1,
                itemCount = 0
            )
            mainViewModel.updateItem(myAdapter.itemCount, newItem)
        }
    }
}