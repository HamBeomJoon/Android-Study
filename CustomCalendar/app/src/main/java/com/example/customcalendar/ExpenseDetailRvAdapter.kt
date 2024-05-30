package com.example.customcalendar

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.customcalendar.databinding.ItemExpenseListBinding

class ExpenseDetailRvAdapter(val expenseList: List<String>): RecyclerView.Adapter<ExpenseDetailRvAdapter.ExpenseDetail>() {

    inner class ExpenseDetail(val binding: ItemExpenseListBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpenseDetail {
        val binding = ItemExpenseListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ExpenseDetail(binding)
    }

    override fun getItemCount(): Int {
        return expenseList.size
    }

    override fun onBindViewHolder(holder: ExpenseDetail, position: Int) {
        holder.binding.tvExpenseDetail.text = expenseList[position]
    }
}