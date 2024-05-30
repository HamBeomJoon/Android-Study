package com.example.customcalendar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper


import com.example.customcalendar.databinding.ActivityMainBinding
import kotlin.math.exp

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var expenseList = mutableListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val monthListManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val monthListAdapter = MonthRvAdapter()

        binding.rvCalendar.apply {
            layoutManager = monthListManager
            adapter = monthListAdapter
            scrollToPosition(Int.MAX_VALUE / 2)
        }
        val snap = PagerSnapHelper()
        snap.attachToRecyclerView(binding.rvCalendar)

        expenseList.add("aaa1")
        expenseList.add("aaa2")
        expenseList.add("aaa3")
        val expenseDetailRvAdapter = ExpenseDetailRvAdapter(expenseList)

        binding.rvExpneseList.apply {
            layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            adapter = expenseDetailRvAdapter
        }

    }
}