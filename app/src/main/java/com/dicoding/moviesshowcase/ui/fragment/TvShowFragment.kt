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
import com.dicoding.moviesshowcase.ui.adapter.ListTvShowAdapter
import com.dicoding.moviesshowcase.data.source.local.entity.TvEntity
import com.dicoding.moviesshowcase.model.ListDataViewModel
import com.dicoding.moviesshowcase.model.ViewModelFactory
import com.dicoding.moviesshowcase.utils.Helper.TYPE_TV
import com.dicoding.moviesshowcase.vo.Resource
import com.dicoding.moviesshowcase.vo.Status
import kotlinx.android.synthetic.main.fragment_tv_show.*

class TvShowFragment : Fragment() {
    private lateinit var viewModel: ListDataViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tv_show, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val factory = ViewModelFactory.getInstance(requireActivity())

        activity?.let {
            viewModel = ViewModelProvider(it, factory)[ListDataViewModel::class.java]
        }

        viewModel.getTvs().observe(viewLifecycleOwner, { data ->
            val listTvShowAdapter = ListTvShowAdapter()

            when(data.status){
                Status.LOADING -> Resource.loading(true)
                Status.SUCCESS -> {
                    Resource.loading(false)
                    listTvShowAdapter.submitList(data.data)
                    listTvShowAdapter.notifyDataSetChanged()
                }
                Status.ERROR -> {
                    Resource.loading(false)
                    Toast.makeText(context, "Fetch data error", Toast.LENGTH_SHORT).show()
                }
            }

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
        detailActivity.putExtra(DetailActivity.EXTRA_TYPE, TYPE_TV)
        startActivity(detailActivity)
    }
}