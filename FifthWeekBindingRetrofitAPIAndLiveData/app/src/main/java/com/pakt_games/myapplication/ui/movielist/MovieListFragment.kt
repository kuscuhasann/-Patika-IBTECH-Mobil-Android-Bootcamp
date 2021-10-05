package com.pakt_games.myapplication.ui.movielist

import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.pakt_games.myapplication.R
import com.pakt_games.myapplication.base.BaseFragment
import com.pakt_games.myapplication.databinding.FragmentMovieListBinding
import com.pakt_games.myapplication.ui.movielist.adapter.IMovieListRecyclerViewListener
import com.pakt_games.myapplication.ui.movielist.adapter.MovieListRecyclerAdapter


class MovieListFragment : BaseFragment<MovieListViewModel, FragmentMovieListBinding> () , IMovieListRecyclerViewListener{
    override var viewModel: MovieListViewModel?= null
    override fun getLayoutID() = R.layout.fragment_movie_list

    override fun prepareViewModel() {
        viewModel = ViewModelProvider(this).get(MovieListViewModel::class.java)
    }

    override fun observeLiveData() {
        viewModel?.moviesResponse?.observe(this, {

            dataBinding.model = it
            dataBinding.executePendingBindings()

            dataBinding.recyclerView.adapter = MovieListRecyclerAdapter(it.getList(),this)

        })
    }

    override fun onclick(view: View, uuid: Int) {
        val action=MovieListFragmentDirections.actionMovieListFragmentToMovieDetailFragment(uuid)
        Navigation.findNavController(view).navigate(action)
    }


}