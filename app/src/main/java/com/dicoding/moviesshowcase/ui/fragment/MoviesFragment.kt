package com.dicoding.moviesshowcase.ui.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.dicoding.moviesshowcase.R
import com.dicoding.moviesshowcase.ui.activity.DetailActivity
import com.dicoding.moviesshowcase.ui.adapter.ListMovieAdapter
import com.dicoding.moviesshowcase.data.source.local.entity.MvEntity
import com.dicoding.moviesshowcase.model.ListDataViewModel
import com.dicoding.moviesshowcase.model.ViewModelFactory
import com.dicoding.moviesshowcase.utils.Helper.TYPE_MV
import com.dicoding.moviesshowcase.vo.Resource.Companion.loading
import com.dicoding.moviesshowcase.vo.Status
import kotlinx.android.synthetic.main.fragment_movies.*

class MoviesFragment : Fragment() {
    private lateinit var viewModel: ListDataViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movies, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val factory = ViewModelFactory.getInstance(requireActivity())

        activity?.let {
            viewModel = ViewModelProvider(it, factory)[ListDataViewModel::class.java]
        }

        viewModel.getMovies().observe(viewLifecycleOwner, { data ->
            val listMovieAdapter = ListMovieAdapter()

            when(data.status){
                Status.LOADING -> loading(true)
                Status.SUCCESS -> {
                    loading(false)
                    listMovieAdapter.submitList(data.data)
                    listMovieAdapter.notifyDataSetChanged()
                }
                Status.ERROR -> {
                    loading(false)
                    Toast.makeText(context, "Fetch data error", Toast.LENGTH_SHORT).show()
                }
            }

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
        detailActivity.putExtra(DetailActivity.EXTRA_TYPE, TYPE_MV)
        startActivity(detailActivity)
    }
}
