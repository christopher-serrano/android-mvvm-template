package moe.cachapa.android.mvvm.template.network.api

import moe.cachapa.android.mvvm.template.data.model.MovieDetail
import moe.cachapa.android.mvvm.template.data.model.response.TrendingMovieListResponse
import moe.cachapa.android.mvvm.template.data.model.response.UpcomingMovieListResponse
import moe.cachapa.android.mvvm.template.data.model.response.VideoListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface Endpoints {

    //GET Movie Detail
    @GET("/movie/{movie_id}")
    suspend fun getMovieDetail(@Path(value = "movie_id") movieId: Int): Response<MovieDetail?>

    //GET Trending List
    //option param accepts "day" (for the day) or "week"
    @GET("/trending/movie/{option}")
    suspend fun getTrendingMovieList(@Path(value = "option") option: String): Response<TrendingMovieListResponse?>

    //GET Upcoming movie list
    @GET("/movie/upcoming")
    suspend fun getUpcomingMovieList(): Response<UpcomingMovieListResponse?>

    @GET("/movie/{movie_id}/videos")
    suspend fun getMovieVideos(@Path(value = "movie_id") movieId: Int): Response<VideoListResponse?>

}