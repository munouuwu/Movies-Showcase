package com.dicoding.moviesshowcase.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dicoding.moviesshowcase.R
import com.dicoding.moviesshowcase.data.Data

class ListDataAdapter(private val list: List<Data>) : RecyclerView.Adapter<ListDataAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.list_data, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = list [position]
        Glide.with(holder.itemView.context)
            .load("https://image.tmdb.org/t/p/w500/${data.imgPoster}")
            .into(holder.poster)
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(list[holder.adapterPosition]) }
    }

    override fun getItemCount(): Int = list.size

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var poster: ImageView = itemView.findViewById(R.id.img_poster)
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Data)
    }
}