package com.bird394proj.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bird394proj.R
import com.bird394proj.data.Bird
import com.bird394proj.databinding.ItemBirdBinding

class BirdAdapter(
    private val birdList: List<Bird>,
    private val onItemClick: (Bird) -> Unit
) : RecyclerView.Adapter<BirdAdapter.BirdViewHolder>() {

    inner class BirdViewHolder(private val binding: ItemBirdBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(bird: Bird) {
            binding.bird = bird
            binding.root.setOnClickListener { onItemClick(bird) }
            binding.executePendingBindings() // Update the UI immediately
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BirdViewHolder {
        val binding: ItemBirdBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_bird,
            parent,
            false
        )
        return BirdViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BirdViewHolder, position: Int) {
        holder.bind(birdList[position])
    }

    override fun getItemCount(): Int = birdList.size
}
