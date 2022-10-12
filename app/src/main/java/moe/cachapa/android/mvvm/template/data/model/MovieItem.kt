package moe.cachapa.android.mvvm.template.data.model

import com.google.gson.annotations.SerializedName

data class MovieItem(
    @SerializedName("adult")
    var adult: Boolean?,
    @SerializedName("backdrop_path")
    var backdropPath: String?,
    @SerializedName("id")
    var id: Int?,
    @SerializedName("title")
    var title: String?,
    @SerializedName("original_language")
    var originalLanguage: String?,
    @SerializedName("original_title")
    var originalTitle: String?,
    @SerializedName("overview")
    var overview: String?,
    @SerializedName("poster_path")
    var posterPath: String?,
    @SerializedName("media_type")
    var mediaType: String?,
    @SerializedName("genre_ids")
    var genreIds: List<Int>?,
    @SerializedName("popularity")
    var popularity: Double?,
    @SerializedName("release_date")
    var releaseDate: String?,
    @SerializedName("video")
    var video: Boolean?,
    @SerializedName("vote_average")
    var voteAverage: Double?,
    @SerializedName("vote_count")
    var voteCount: Int?
)