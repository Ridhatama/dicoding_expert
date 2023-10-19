package com.iftah.favorite

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.iftah.core.ui.MovieAdapter
import com.iftah.favorite.databinding.FragmentFavoriteBinding
import com.iftah.movieapp.detail.DetailMovieActivity
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules


class FavoriteFragment : Fragment() {

    private lateinit var binding: FragmentFavoriteBinding
    private val favoriteViewModel: FavoriteViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoriteBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        loadKoinModules(favoriteModule)

        val favoriteAdapter = MovieAdapter()



        favoriteViewModel.getFavoriteMovie.observe(viewLifecycleOwner) { favoriteMovie ->
            favoriteAdapter.setData(favoriteMovie)
            rvSettings(binding.rvFavorite, favoriteAdapter)
        }
    }

    private fun rvSettings(recyclerView: RecyclerView, movieAdapter: MovieAdapter) {
        recyclerView.layoutManager = GridLayoutManager(context, 2)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = movieAdapter

        movieAdapter.onItemClick = { selectedData ->
            val intent = Intent(activity, DetailMovieActivity::class.java)
            intent.putExtra(DetailMovieActivity.EXTRA_DATA, selectedData)
            startActivity(intent)
        }
    }
}