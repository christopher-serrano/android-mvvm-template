package moe.cachapa.android.mvvm.template.data.model.response


import com.google.gson.annotations.SerializedName
import moe.cachapa.android.mvvm.template.data.model.Dates
import moe.cachapa.android.mvvm.template.data.model.MovieItem

data class UpcomingMovieListResponse(
    @SerializedName("dates")
    var dates: Dates?,
    @SerializedName("page")
    var page: Int?,
    @SerializedName("results")
    var results: List<MovieItem>?,
    @SerializedName("total_pages")
    var totalPages: Int?,
    @SerializedName("total_results")
    var totalResults: Int?
)