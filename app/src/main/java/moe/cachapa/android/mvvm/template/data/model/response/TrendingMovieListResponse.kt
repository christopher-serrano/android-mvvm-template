package moe.cachapa.android.mvvm.template.data.model.response


import com.google.gson.annotations.SerializedName
import moe.cachapa.android.mvvm.template.data.model.MovieItem

data class TrendingMovieListResponse(
    @SerializedName("page")
    val page: Int?,
    @SerializedName("results")
    val results: List<MovieItem?>?,
    @SerializedName("total_pages")
    val totalPages: Int?,
    @SerializedName("total_results")
    val totalResults: Int?
) {

}