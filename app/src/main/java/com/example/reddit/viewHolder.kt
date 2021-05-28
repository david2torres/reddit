package com.example.reddit

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.reddit.databinding.ItemRedditBinding

class viewHolder (view: View): RecyclerView.ViewHolder(view) {

    private val binding = ItemRedditBinding.bind(view)

    fun bind (data: String) {
        binding.ivDog
    }
}