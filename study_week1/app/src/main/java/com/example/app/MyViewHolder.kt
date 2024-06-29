package com.example.app

import androidx.recyclerview.widget.RecyclerView
import com.example.app.databinding.ViewItemlistBinding
import com.google.android.material.snackbar.Snackbar

class MyViewHolder(private val binding: ViewItemlistBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(data: Monster) {
        with(binding) {
            tvName.text = "Name: ${data.name}"
            tvRace.text = "Race: ${data.race}"
            tvLevel.text = "Level: ${data.level}"
            tvStats.text = "HP: ${data.stats[0]} / MP: ${data.stats[1]} / Exp: ${data.stats[2]}"
            tvEncount.text = "Encounted: ${data.encount}"

            vhLayout.setOnClickListener {
                Snackbar.make(it, "Item $bindingAdapterPosition touched!", Snackbar.LENGTH_SHORT)
                    .show()
            }
        }
    }

    fun setAlpha(alpha: Float) {
        with(binding) {
            tvName.alpha = alpha
            tvRace.alpha = alpha
            tvLevel.alpha = alpha
            tvStats.alpha = alpha
            tvEncount.alpha = alpha
        }
    }
}
