package com.dicoding.moviesshowcase.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dicoding.moviesshowcase.data.source.local.entity.TvEntity
import com.dicoding.moviesshowcase.databinding.ListDataBinding

class ListTvShowAdapter() :
    PagedListAdapter<TvEntity, ListTvShowAdapter.ListViewHolder>(DIFF_CALLBACK)  {
    private lateinit var onItemClickCallback: OnItemClickCallback

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TvEntity>() {
            override fun areItemsTheSame(oldItem: TvEntity, newItem: TvEntity): Boolean {
                return oldItem.tvId == newItem.tvId
            }
            override fun areContentsTheSame(oldItem: TvEntity, newItem: TvEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    inner class ListViewHolder(private val binding: ListDataBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: TvEntity) {
            with(binding) {
                Glide.with(itemView.context)
                    .load("https://image.tmdb.org/t/p/w500/${data.poster}")
                    .into(imgPoster)
                itemView.setOnClickListener {
                    onItemClickCallback.onItemClicked(data)
                }
            }
        }
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val listDataBinding =
            ListDataBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ListViewHolder(listDataBinding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val movie = getItem(position)
        if (movie != null) {
            holder.bind(movie)
        }
    }

    /*inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var poster: ImageView = itemView.findViewById(R.id.img_poster)
    }*/

    interface OnItemClickCallback {
        fun onItemClicked(data: TvEntity)
    }
}