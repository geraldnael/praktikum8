package com.ifs21015.pampraktikum8

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PictAdapter(private val context: Context, private val dataList: List<Int>) :
    RecyclerView.Adapter<PictAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_row_pict, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = dataList[position]
        holder.imageView.setImageResource(currentItem) // Menggunakan currentItem langsung
        // Tidak perlu mengatur text atau listener karena tidak ada teks atau klik yang berkaitan dengan daftar gambar
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}
