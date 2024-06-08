package com.example.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.ItemRecyclerviewBinding

class CustomAdapter(val profileList: ArrayList<Profile>) :
    RecyclerView.Adapter<CustomAdapter.Holder>() {
    override fun getItemCount(): Int {
        return profileList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomAdapter.Holder {
        val binding =
            ItemRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: CustomAdapter.Holder, position: Int) {
        holder.name.text = profileList[position].name
        holder.age.text = profileList[position].category
    }

    inner class Holder(val binding: ItemRecyclerviewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val name = binding.rvName
        val age = binding.rvAge
    }
}