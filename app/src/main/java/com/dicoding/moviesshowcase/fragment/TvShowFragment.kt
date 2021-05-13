package com.dicoding.moviesshowcase.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.moviesshowcase.R
import com.dicoding.moviesshowcase.activity.DetailActivity
import com.dicoding.moviesshowcase.adapter.ListDataAdapter
import com.dicoding.moviesshowcase.model.Data
import kotlinx.android.synthetic.main.fragment_tv_show.*

class TvShowFragment : Fragment() {
    private var list: ArrayList<Data> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv_show, container, false)
    }

    private fun showRecyclerList() {
        rv_infos.layoutManager = LinearLayoutManager(activity)
        val listDataAdapter = ListDataAdapter(list)
        rv_infos.adapter = listDataAdapter

        listDataAdapter.setOnItemClickCallback(object : ListDataAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Data) {
                showSelectedInfo(data)
            }
        })
    }

    private fun showSelectedInfo(data: Data) {
        val detailActivity = Intent(activity, DetailActivity::class.java)
        detailActivity.putExtra(DetailActivity.EXTRA_USER, data)
        startActivity(detailActivity)
    }
}