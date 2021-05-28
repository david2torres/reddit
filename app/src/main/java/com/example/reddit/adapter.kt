package com.example.reddit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
class adapter (val reddit: List<String>):RecyclerView.Adapter<viewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return viewHolder(layoutInflater.inflate(R.layout.item_reddit, parent, false))
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val item = reddit[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return reddit.size
    }
}