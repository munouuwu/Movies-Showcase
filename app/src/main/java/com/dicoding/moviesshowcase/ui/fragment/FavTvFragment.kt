package com.dicoding.moviesshowcase.ui.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.dicoding.moviesshowcase.R
import com.dicoding.moviesshowcase.data.source.local.entity.TvEntity
import com.dicoding.moviesshowcase.model.ListDataViewModel
import com.dicoding.moviesshowcase.model.ViewModelFactory
import com.dicoding.moviesshowcase.ui.activity.DetailActivity
import com.dicoding.moviesshowcase.ui.adapter.ListMovieAdapter
import com.dicoding.moviesshowcase.ui.adapter.ListTvShowAdapter
import com.dicoding.moviesshowcase.utils.Helper
import kotlinx.android.synthetic.main.fragment_movies.*
import kotlinx.android.synthetic.main.fragment_movies.rv_mv
import kotlinx.android.synthetic.main.fragment_tv_show.*

class FavTvFragment : Fragment() {
    private lateinit var viewModel: ListDataViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_fav_tv, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val factory = ViewModelFactory.getInstance(requireActivity())

        activity?.let {
            viewModel = ViewModelProvider(it, factory)[ListDataViewModel::class.java]
        }

        viewModel.getFavoriteTv().observe(viewLifecycleOwner, { data ->
            val listTvShowAdapter = ListTvShowAdapter()
            listTvShowAdapter.submitList(data)
            listTvShowAdapter.notifyDataSetChanged()

            showRecyclerList(listTvShowAdapter)
        })
    }

    private fun showRecyclerList(listTvShowAdapter: ListTvShowAdapter) {
        rv_tv.layoutManager = GridLayoutManager(context, 2)
        rv_tv.adapter = listTvShowAdapter

        listTvShowAdapter.setOnItemClickCallback(object : ListTvShowAdapter.OnItemClickCallback {
            override fun onItemClicked(data: TvEntity) {
                showSelectedInfo(data)
            }
        })
    }

    private fun showSelectedInfo(data: TvEntity) {
        val detailActivity = Intent(context, DetailActivity::class.java)
        detailActivity.putExtra(DetailActivity.EXTRA_ID, data.id)
        detailActivity.putExtra(DetailActivity.EXTRA_TYPE, Helper.TYPE_TV)
        startActivity(detailActivity)
    }
}