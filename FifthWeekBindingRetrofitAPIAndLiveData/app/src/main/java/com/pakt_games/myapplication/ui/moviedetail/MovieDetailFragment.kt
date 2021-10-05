package com.pakt_games.myapplication.ui.moviedetail

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.pakt_games.myapplication.R
import com.pakt_games.myapplication.base.BaseFragment
import com.pakt_games.myapplication.databinding.FragmentMovieDetailBinding


class MovieDetailFragment() : BaseFragment<MovieDetailViewModel, FragmentMovieDetailBinding>() {
    override var viewModel: MovieDetailViewModel?= null
    override fun getLayoutID(): Int = R.layout.fragment_movie_detail
    private var movieId = 0

    override fun prepareViewModel() {
        viewModel = ViewModelProvider(this).get(MovieDetailViewModel::class.java)
    }

    fun getSingleMovieData()
    {
        arguments?.let {
            movieId = MovieDetailFragmentArgs.fromBundle(it).movieId
        }
        viewModel!!.getRoomData(movieId)
    }
    override fun observeLiveData() {
       getSingleMovieData()
        viewModel?.movieLiveData?.observe(viewLifecycleOwner, Observer { movie->
            movie?.let {
                dataBinding.model=it
            }
        })
    }
}