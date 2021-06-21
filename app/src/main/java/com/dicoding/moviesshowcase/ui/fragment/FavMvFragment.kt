package com.dicoding.moviesshowcase.ui.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.dicoding.moviesshowcase.R
import com.dicoding.moviesshowcase.data.source.local.entity.MvEntity
import com.dicoding.moviesshowcase.model.ListDataViewModel
import com.dicoding.moviesshowcase.model.ViewModelFactory
import com.dicoding.moviesshowcase.ui.activity.DetailActivity
import com.dicoding.moviesshowcase.ui.adapter.ListMovieAdapter
import com.dicoding.moviesshowcase.utils.Helper
import kotlinx.android.synthetic.main.fragment_movies.*

class FavMvFragment : Fragment() {
    private lateinit var viewModel: ListDataViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_fav_mv, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val factory = ViewModelFactory.getInstance(requireActivity())

        activity?.let {
            viewModel = ViewModelProvider(it, factory)[ListDataViewModel::class.java]
        }

        viewModel.getFavoriteMv().observe(viewLifecycleOwner, { data ->
                val listMovieAdapter = ListMovieAdapter()
                listMovieAdapter.submitList(data)
                listMovieAdapter.notifyDataSetChanged()

                showRecyclerList(listMovieAdapter)
        })
    }

    private fun showRecyclerList(listMovieAdapter: ListMovieAdapter) {
        rv_mv.layoutManager = GridLayoutManager(context, 2)
        rv_mv.adapter = listMovieAdapter

        listMovieAdapter.setOnItemClickCallback(object : ListMovieAdapter.OnItemClickCallback {
            override fun onItemClicked(data: MvEntity) {
                showSelectedInfo(data)
            }
        })
    }

    private fun showSelectedInfo(data: MvEntity) {
        val detailActivity = Intent(context, DetailActivity::class.java)
        detailActivity.putExtra(DetailActivity.EXTRA_ID, data.id)
        detailActivity.putExtra(DetailActivity.EXTRA_TYPE, Helper.TYPE_MV)
        startActivity(detailActivity)
    }
}