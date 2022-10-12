package moe.cachapa.android.mvvm.template.repository

import moe.cachapa.android.mvvm.template.data.model.MovieDetail
import moe.cachapa.android.mvvm.template.data.model.MovieItem

interface MovieRepository {

    suspend fun getUpcomingMovieList(): List<MovieItem>?
    suspend fun getTrendingMovieList(): List<MovieItem>?
    suspend fun getMovieDetail(movieId: Int): MovieDetail?
    suspend fun getMovieVideos(movieId: Int): List<MovieItem>?

    suspend fun fetchUpcomingMovies(): List<MovieItem>?
    suspend fun fetchTrendingMovies(): List<MovieItem>?
    suspend fun fetchMovieDetail(movieId: Int): MovieDetail?
}