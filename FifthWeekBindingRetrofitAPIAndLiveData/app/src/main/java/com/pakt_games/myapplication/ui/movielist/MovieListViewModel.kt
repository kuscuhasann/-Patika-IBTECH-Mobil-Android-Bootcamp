package com.pakt_games.myapplication.ui.movielist

import android.app.Application
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.pakt_games.myapplication.base.BaseViewModel
import com.pakt_games.myapplication.db.MovieDataBase
import com.pakt_games.myapplication.repository.MovieRepository
import com.pakt_games.myapplication.ui.movielist.model.Movie
import com.pakt_games.myapplication.ui.movielist.model.MovieListViewStateModel
import com.pakt_games.myapplication.util.API_KEY
import kotlinx.coroutines.launch

class MovieListViewModel(application: Application) : BaseViewModel(application) {


    val moviesResponse = MediatorLiveData<MovieListViewStateModel>()
    val movieRepository = MovieRepository()

    init {
        movieRepository.getAllMovies(API_KEY)

        moviesResponse.addSource(movieRepository.movieList) {
            moviesResponse.value = MovieListViewStateModel(it)
            saveToDataInSQLite(it.movies)
        }
    }

    private fun saveToDataInSQLite(foodList:List<Movie>){
        launch {
            val dao=MovieDataBase(getApplication()).movieDAO()
            dao.deleteAllFoods()
            val uuidList = dao.insertAll(*foodList.toTypedArray())
            dao.getAllFoods()
            var i=0
            while (i<foodList.size) {
                foodList[i].uuid = uuidList[i].toInt()
                i=i+1
            }
        }
    }
}