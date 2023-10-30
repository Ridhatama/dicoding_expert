package com.iftah.movieapp.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.iftah.core.ui.MovieAdapter
import com.iftah.movieapp.R
import com.iftah.movieapp.databinding.FragmentHomeBinding
import com.iftah.movieapp.detail.DetailMovieActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val homeViewModel: HomeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {


            val allMovieAdapter = MovieAdapter()
            val topRatedAdapter = MovieAdapter()
            val popularAdapter = MovieAdapter()

            homeViewModel.allMovies.observe(viewLifecycleOwner) { movie ->
                if (movie != null) {
                    when (movie) {
                        is com.iftah.core.data.Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                        is com.iftah.core.data.Resource.Success -> {
                            binding.progressBar.visibility = View.GONE
                            allMovieAdapter.setData(movie.data)
                        }

                        is com.iftah.core.data.Resource.Error -> {
                            binding.progressBar.visibility = View.GONE
                            binding.viewError.root.visibility = View.VISIBLE
                            binding.viewError.tvError.text =
                                movie.message ?: getString(R.string.something_wrong)
                            binding.tvMovies.visibility = View.GONE
                            binding.tvPopular.visibility = View.GONE
                            binding.tvTopRated.visibility = View.GONE
                        }
                    }
                }
                rvSettings(binding.rvMovies, allMovieAdapter)
            }

            homeViewModel.topRatedMovies.observe(viewLifecycleOwner) { movie ->
                topRatedAdapter.setData(movie)
                rvSettings(binding.rvTopRated, topRatedAdapter)
            }

            homeViewModel.popularMovies.observe(viewLifecycleOwner) { movie ->
                popularAdapter.setData(movie)
                rvSettings(binding.rvPopular, popularAdapter)
            }

        }

    }

    private fun rvSettings(recyclerView: RecyclerView, movieAdapter: MovieAdapter){
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = movieAdapter

        movieAdapter.onItemClick = { selectedData ->
            val intent = Intent(activity, DetailMovieActivity::class.java)
            intent.putExtra(DetailMovieActivity.EXTRA_DATA, selectedData)
            startActivity(intent)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}