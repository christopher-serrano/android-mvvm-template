package moe.cachapa.android.mvvm.template.repository

import moe.cachapa.android.mvvm.template.data.model.MovieDetail
import moe.cachapa.android.mvvm.template.data.model.MovieItem
import moe.cachapa.android.mvvm.template.network.api.ApiClient
import org.koin.core.component.KoinComponent

class MovieRepositoryImpl : MovieRepository, KoinComponent {

    private val api = ApiClient.invoke()

    override suspend fun getUpcomingMovieList(): List<MovieItem>? {
        TODO("Not yet implemented")
    }

    override suspend fun getTrendingMovieList(): List<MovieItem>? {
        TODO("Not yet implemented")
    }

    override suspend fun getMovieDetail(movieId: Int): MovieDetail? {
        TODO("Not yet implemented")
    }

    override suspend fun getMovieVideos(movieId: Int): List<MovieItem>? {
        TODO("Not yet implemented")
    }

    override suspend fun fetchUpcomingMovies(): List<MovieItem>? {
        TODO("Not yet implemented")
    }

    override suspend fun fetchTrendingMovies(): List<MovieItem>? {
        TODO("Not yet implemented")
    }

    override suspend fun fetchMovieDetail(movieId: Int): MovieDetail? {
        TODO("Not yet implemented")
    }
}