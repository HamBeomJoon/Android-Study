package com.example.customcalendar

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.customcalendar.databinding.ItemListMonthBinding
import java.util.*

class MonthRvAdapter : RecyclerView.Adapter<MonthRvAdapter.MonthView>() {
    private val center = Int.MAX_VALUE / 2
    private val calendar = Calendar.getInstance()

    inner class MonthView(val binding: ItemListMonthBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MonthView {
        val binding = ItemListMonthBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MonthView(binding)
    }

    override fun onBindViewHolder(holder: MonthView, position: Int) {
        calendar.time = Date()
        calendar.set(Calendar.DAY_OF_MONTH, 1)
        calendar.add(Calendar.MONTH, position - center)
        holder.binding.tvMonth.text =
            "${calendar.get(Calendar.YEAR)}년 ${calendar.get(Calendar.MONTH) + 1}월"
        val tempMonth = calendar.get(Calendar.MONTH)

        val dayList: MutableList<Date> = mutableListOf()
        val tempCalendar = calendar.clone() as Calendar

        tempCalendar.set(Calendar.DAY_OF_MONTH, 1)
        val firstDayOfWeek = tempCalendar.get(Calendar.DAY_OF_WEEK) - 1 // Sunday is 1, need to shift to 0-based
        tempCalendar.add(Calendar.DAY_OF_MONTH, -firstDayOfWeek)

        for (i in 0 until 6 * 7) {
            dayList.add(tempCalendar.time)
            tempCalendar.add(Calendar.DAY_OF_MONTH, 1)
        }

        val dayListManager = GridLayoutManager(holder.binding.root.context, 7)
        val dayListAdapter = DayRvAdapter(tempMonth, dayList)

        holder.binding.rvDayList.apply {
            layoutManager = dayListManager
            adapter = dayListAdapter
        }
    }

    override fun getItemCount(): Int {
        return Int.MAX_VALUE
    }
}
