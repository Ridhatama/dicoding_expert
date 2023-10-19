package com.iftah.movieapp.detail

import android.annotation.SuppressLint
import android.nfc.NfcAdapter.EXTRA_DATA
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.iftah.core.domain.model.Movie
import com.iftah.movieapp.R
import com.iftah.movieapp.databinding.ActivityDetailBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailMovieActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private val detailMovieViewModel: DetailMovieViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val detailMovie = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(EXTRA_DATA, Movie::class.java)
        } else {
            intent.getParcelableExtra(EXTRA_DATA)
        }

        showDetailMovie(detailMovie)

        binding.back.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

    }

    @SuppressLint("SetTextI18n")
    private fun showDetailMovie(dataMovie: Movie?) {
        dataMovie?.let {
            with(binding) {
                Glide.with(this@DetailMovieActivity).load(getString(com.iftah.core.R.string.tmdb_image_url) + it.backdropPoster)
                    .into(posterMovies)
                title.text = it.movieName
                overview.text = it.description
                rating.text = it.voteAverage.toString() + getString(R.string.rating)
                var statusFavorite = dataMovie.isFavorite
                setStatusFavorite(statusFavorite)

                favorite.setOnClickListener{
                    statusFavorite = !statusFavorite
                    detailMovieViewModel.setFavoriteMovie(dataMovie, statusFavorite)
                    setStatusFavorite(statusFavorite)
                }
            }
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding.favorite.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.favorite_red
                )
            )
        } else {
            binding.favorite.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.favorite))
        }
    }

    companion object {
        const val EXTRA_DATA = "extra_data"
    }
}

