package moe.cachapa.android.mvvm.template.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import moe.cachapa.android.mvvm.template.data.db.dao.MovieDetailDao
import moe.cachapa.android.mvvm.template.data.db.dao.MovieItemDao
import moe.cachapa.android.mvvm.template.data.db.dao.VideoDao
import moe.cachapa.android.mvvm.template.data.model.MovieDetail
import moe.cachapa.android.mvvm.template.data.model.MovieItem
import moe.cachapa.android.mvvm.template.network.api.ApiClient
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class MovieRepositoryImpl : MovieRepository, KoinComponent {

    private val api = ApiClient.invoke()

    private val movieDetailDao: MovieDetailDao by inject()
    private val movieItemDao: MovieItemDao by inject()
    private val videoDao: VideoDao by inject()

    override suspend fun getUpcomingMovieList(): List<MovieItem>? = withContext(Dispatchers.IO) {
        val result = api.getUpcomingMovieList()
        val list = result.body()?.results
        list
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
