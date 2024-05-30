package com.example.customcalendar

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.customcalendar.databinding.ItemListDayBinding
import java.util.*

class DayRvAdapter(val tempMonth: Int, val dayList: MutableList<Date>) : RecyclerView.Adapter<DayRvAdapter.DayView>() {
    private val ROW = 6

    inner class DayView(val binding: ItemListDayBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayView {
        val binding = ItemListDayBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DayView(binding)
    }

    override fun onBindViewHolder(holder: DayView, position: Int) {
        val calendar = Calendar.getInstance().apply {
            time = dayList[position]
        }
        val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)
        val month = calendar.get(Calendar.MONTH)

        holder.binding.layoutDay.setOnClickListener {
            Toast.makeText(holder.binding.root.context, "${dayList[position]}", Toast.LENGTH_SHORT).show()
        }
        holder.binding.tvDay.text = dayOfMonth.toString()

        holder.binding.tvDay.setTextColor(
            when (position % 7) {
                0 -> Color.RED
                6 -> Color.BLUE
                else -> Color.BLACK
            }
        )

        if (tempMonth != month) {
            holder.binding.tvDay.alpha = 0.4f
        }
    }

    override fun getItemCount(): Int {
        return ROW * 7
    }
}
