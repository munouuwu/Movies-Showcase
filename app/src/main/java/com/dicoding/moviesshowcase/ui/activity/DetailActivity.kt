package com.dicoding.moviesshowcase.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.dicoding.moviesshowcase.R
import com.dicoding.moviesshowcase.databinding.ActivityDetailBinding
import com.dicoding.moviesshowcase.data.source.local.entity.MvEntity
import com.dicoding.moviesshowcase.data.source.local.entity.TvEntity
import com.dicoding.moviesshowcase.model.DetailActivityViewModel
import com.dicoding.moviesshowcase.model.ViewModelFactory
import com.dicoding.moviesshowcase.utils.Helper.TYPE_MV
import com.dicoding.moviesshowcase.utils.Helper.TYPE_TV
import com.dicoding.moviesshowcase.vo.Resource.Companion.loading
import com.dicoding.moviesshowcase.vo.Status
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityDetailBinding
    private lateinit var viewModel: DetailActivityViewModel

    private lateinit var mvEntity: MvEntity
    private lateinit var tvEntity: TvEntity

    private var type: String? = null
    private var id: Int = 0

    companion object {
        const val EXTRA_ID = "extra_id"
        const val EXTRA_TYPE = "extra_type"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        btn_favorite.setOnClickListener(this)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this@DetailActivity, factory)[DetailActivityViewModel::class.java]

        getData()
    }

    private fun getData(){
        id = intent.getIntExtra(EXTRA_ID, 0)
        type = intent.getStringExtra(EXTRA_TYPE)

        if (type.equals(TYPE_MV, ignoreCase = true)) {
            id?.let {
                viewModel.setSelectedMv(it)
            }
            viewModel.getMvById().observe(this, { item ->
                when(item.status){
                    Status.LOADING -> loading(true)
                    Status.SUCCESS -> {
                        item.data.let {
                            if (it != null) {
                                loading(false)
                                mvEntity = it
                                showMvData(it)
                                isFavorite(it.isFavorite)
                            }
                        }
                    }
                    Status.ERROR -> {
                        loading(false)
                        Toast.makeText(applicationContext, "Something Wrong..", Toast.LENGTH_SHORT).show()
                    }
                }
            })
        } else if (type.equals(TYPE_TV, ignoreCase = true)) {
            id?.let {
                viewModel.setSelectedTv(it)
            }
            viewModel.getTvById().observe(this, { item ->
                when(item.status){
                    Status.LOADING -> loading(true)
                    Status.SUCCESS -> {
                        item.data.let {
                            if (it != null) {
                                loading(false)
                                tvEntity = it
                                showTvData(it)
                                isFavorite(it.isFavorite)
                            }
                        }
                    }
                    Status.ERROR -> {
                        loading(false)
                        Toast.makeText(applicationContext, "Something Wrong..", Toast.LENGTH_SHORT).show()
                    }
                }
            })
        }
    }

    private fun showMvData(mvData: MvEntity){
        tv_title.text = mvData.title
        tv_title_header.text = getString(R.string.title_header)

        tv_language.text = mvData.language
        tv_language_header.text = getString(R.string.language_header)

        tv_rating.text = mvData.rating.toString()
        tv_rating_header.text = getString(R.string.rating_header)

        tv_release.text = mvData.releaseDate
        tv_release_header.text = getString(R.string.release_header)

        tv_duration.text = "${mvData.runtime.toString()} Minutes"
        tv_genre.text = mvData.genres
        tv_overview.text = mvData.overview

        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w500/${mvData.poster}")
            .into(detail_poster)
    }

    private fun showTvData(tvData: TvEntity){
        tv_title.text = tvData.title
        tv_title_header.text = getString(R.string.title_header)

        tv_language.text = tvData.language
        tv_language_header.text = getString(R.string.language_header)

        tv_rating.text = tvData.rating.toString()
        tv_rating_header.text = getString(R.string.rating_header)

        tv_release.text = tvData.releaseDate
        tv_release_header.text = getString(R.string.release_header)

        val text = "${tvData.seasons} Seasons / ${tvData.episodes} Episodes"

        tv_duration.text = text
        tv_genre.text = tvData.genres
        tv_overview.text = tvData.overview

        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w500/${tvData.poster}")
            .into(detail_poster)
    }

    private fun isFavorite(state: Boolean){
        val fill: Int = R.drawable.ic_baseline_favorite_24
        val border: Int = R.drawable.ic_baseline_favorite_border_24

        if(state){
            binding.btnFavorite.setImageResource(fill)
        }else{
            binding.btnFavorite.setImageResource(border)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_favorite -> {
                if (type.equals(TYPE_MV, ignoreCase = true)) {
                    viewModel.setFavMv(mvEntity)
                } else if (type.equals(TYPE_TV, ignoreCase = true)) {
                    viewModel.setFavTv(tvEntity)
                }
            }
        }
    }
}