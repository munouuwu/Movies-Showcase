package com.dicoding.moviesshowcase.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.dicoding.moviesshowcase.R
import com.dicoding.moviesshowcase.databinding.ActivityDetailBinding
import com.dicoding.moviesshowcase.data.Data
import com.dicoding.moviesshowcase.model.DetailActivityViewModel
import com.dicoding.moviesshowcase.repo.Helper.TYPE_MV
import com.dicoding.moviesshowcase.repo.Helper.TYPE_TV
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    private lateinit var data : Data

    companion object {
        const val EXTRA_ID = "extra_id"
        const val EXTRA_TYPE = "extra_type"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getData()
    }

    private fun getData(){
        val viewModel = ViewModelProvider(this@DetailActivity, ViewModelProvider.NewInstanceFactory())[DetailActivityViewModel::class.java]

        val id = intent.getIntExtra(EXTRA_ID, 0)
        val type = intent.getStringExtra(EXTRA_TYPE)

        if (type.equals(TYPE_MV, ignoreCase = true)) {
            id?.let {
                viewModel.setSelectedMv(it)
            }
            viewModel.getMvById().observe(this, { item ->
                data = item
                showMvData()
            })
        } else if (type.equals(TYPE_TV, ignoreCase = true)) {
            id?.let {
                viewModel.setSelectedTv(it)
            }
            viewModel.getTvById().observe(this, { item ->
                data = item
                showTvData()
            })
        }
    }

    private fun showMvData(){
        tv_title.text = data.title
        tv_title_header.text = getString(R.string.title_header)

        tv_language.text = data.language
        tv_language_header.text = getString(R.string.language_header)

        tv_rating.text = data.rating.toString()
        tv_rating_header.text = getString(R.string.rating_header)

        tv_release.text = data.release
        tv_release_header.text = getString(R.string.release_header)

        tv_duration.text = "${data.duration.toString()} Minutes"
        tv_genre.text = data.genre
        tv_overview.text = data.overview

        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w500/${data.imgPoster}")
            .into(detail_poster)
    }

    private fun showTvData(){
        tv_title.text = data.title
        tv_title_header.text = getString(R.string.title_header)

        tv_language.text = data.language
        tv_language_header.text = getString(R.string.language_header)

        tv_rating.text = data.rating.toString()
        tv_rating_header.text = getString(R.string.rating_header)

        tv_release.text = data.release
        tv_release_header.text = getString(R.string.release_header)

        val text = "${data.season} Seasons / ${data.episode} Episodes"

        tv_duration.text = text
        tv_genre.text = data.genre
        tv_overview.text = data.overview

        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w500/${data.imgPoster}")
            .into(detail_poster)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}