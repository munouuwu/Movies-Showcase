package com.dicoding.moviesshowcase.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.dicoding.moviesshowcase.R
import com.dicoding.moviesshowcase.activity.DetailActivity
import com.dicoding.moviesshowcase.adapter.ListDataAdapter
import com.dicoding.moviesshowcase.model.Data
import com.dicoding.moviesshowcase.model.ListDataViewModel
import com.dicoding.moviesshowcase.repo.Helper.TYPE_MV
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

        activity?.let {
            viewModel = ViewModelProvider(it, ViewModelProvider.NewInstanceFactory())[ListDataViewModel::class.java]
        }

        val list = viewModel.getMovies()
        showRecyclerList(list)
    }

    private fun showRecyclerList(list: List<Data>) {
        rv_mv.layoutManager = GridLayoutManager(context, 2)
        val listDataAdapter = ListDataAdapter(list)
        rv_mv.adapter = listDataAdapter

        listDataAdapter.setOnItemClickCallback(object : ListDataAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Data) {
                showSelectedInfo(data)
            }
        })
    }

    private fun showSelectedInfo(data: Data) {
        val detailActivity = Intent(context, DetailActivity::class.java)
        detailActivity.putExtra(DetailActivity.EXTRA_ID, data.id)
        detailActivity.putExtra(DetailActivity.EXTRA_TYPE, TYPE_MV)
        startActivity(detailActivity)
    }
}
