package com.example.app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.app.databinding.ItemCharacterBinding

class MyAdapter(private val viewModel: MockViewModel, private var list: List<ItemData> = listOf()) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    private var clickListener: ((ItemData) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_character, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindViewHolder(getItem(position))
    }

    override fun getItemCount(): Int = list.size

    private fun getItem(position: Int) = list[position]

    fun updateList(newList: List<ItemData>) {
        list = newList
        notifyDataSetChanged()
    }

    fun setClickListener(listener: (ItemData) -> Unit) {
        clickListener = listener
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding by lazy { ItemCharacterBinding.bind(itemView) }
        fun bindViewHolder(data: ItemData) {
            binding.apply {
                item = data
                viewHolder = this@ViewHolder
                Glide.with(itemView.context)
                    .load(data.imageUrl)
                    .into(ivCharacter)
            }
        }

        fun clickPlus(itemData: ItemData) {
            viewModel.updateItemCount(adapterPosition, itemData.itemCount + 1)
        }

        fun clickMinus(itemData: ItemData) {
            viewModel.updateItemCount(adapterPosition, itemData.itemCount - 1)
        }
    }
}