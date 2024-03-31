package com.ifs21015.pampraktikum8

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ifs21015.pampraktikum8.databinding.ItemRowInstaBinding

class InstaAdapter(private val context: Context, private val dataList: List<Int>) :
    RecyclerView.Adapter<InstaAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemRowInstaBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val imageView = binding.imageView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding = ItemRowInstaBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val imageResId = dataList[position]
        holder.imageView.setImageResource(imageResId)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}

