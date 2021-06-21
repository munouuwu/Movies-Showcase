package com.dicoding.moviesshowcase.ui.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.dicoding.moviesshowcase.ui.fragment.FavMvFragment
import com.dicoding.moviesshowcase.ui.fragment.FavTvFragment
import com.dicoding.moviesshowcase.ui.fragment.MoviesFragment
import com.dicoding.moviesshowcase.ui.fragment.TvShowFragment

class FavoriteSectionsPagerAdapter (activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = FavMvFragment()
            1 -> fragment = FavTvFragment()
        }
        return fragment as Fragment
    }
}