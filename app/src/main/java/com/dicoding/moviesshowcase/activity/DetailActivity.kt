package com.dicoding.moviesshowcase.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.dicoding.moviesshowcase.R
import com.dicoding.moviesshowcase.databinding.ActivityDetailBinding
import com.dicoding.moviesshowcase.model.Data
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
        showData()
    }

    private fun getData(){
        val viewModel = ViewModelProvider(this@DetailActivity, ViewModelProvider.NewInstanceFactory())[DetailActivityViewModel::class.java]

        val id = intent.getStringExtra(EXTRA_ID)
        val type = intent.getStringExtra(EXTRA_TYPE)

        if (type.equals(TYPE_MV, ignoreCase = true)) {
            id?.let {
                viewModel.setSelectedMv(it)
            }
            data = viewModel.getMvById()
        } else if (type.equals(TYPE_TV, ignoreCase = true)) {
            id?.let {
                viewModel.setSelectedTv(it)
            }
            data = viewModel.getTvById()
        }
    }

    private fun showData(){
        tv_title.text = data.title
        tv_title_header.text = getString(R.string.title_header)

        tv_language.text = data.language
        tv_language_header.text = getString(R.string.language_header)

        tv_rating.text = data.rating
        tv_rating_header.text = getString(R.string.rating_header)

        tv_release.text = data.release
        tv_release_header.text = getString(R.string.release_header)

        tv_duration.text = data.duration
        tv_genre.text = data.genre
        tv_overview.text = data.overview

        Glide.with(this)
            .load(data.imgPoster)
            .into(detail_poster)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}