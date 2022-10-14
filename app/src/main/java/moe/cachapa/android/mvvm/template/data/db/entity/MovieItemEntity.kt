package moe.cachapa.android.mvvm.template.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index

@Entity(
    tableName = "movie_item",
    indices = [Index(value = ["id"], unique = true)]
)
data class MovieItemEntity(
    @ColumnInfo(name = "adult")
    val adult: Boolean?,
    @ColumnInfo(name = "backdrop_path")
    val backdropPath: String?,
    @ColumnInfo(name = "id")
    val id: Int?,
    @ColumnInfo(name = "title")
    val title: String?,
    @ColumnInfo(name = "original_language")
    val originalLanguage: String?,
    @ColumnInfo(name = "original_title")
    val originalTitle: String?,
    @ColumnInfo(name = "overview")
    val overview: String?,
    @ColumnInfo(name = "poster_path")
    val posterPath: String?,
    @ColumnInfo(name = "media_type")
    val mediaType: String?,
    @ColumnInfo(name = "genre_ids")
    val genreIds: List<Int>?,
    @ColumnInfo(name = "popularity")
    val popularity: Double?,
    @ColumnInfo(name = "release_date")
    val releaseDate: String?,
    @ColumnInfo(name = "video")
    val video: Boolean?,
    @ColumnInfo(name = "vote_average")
    val voteAverage: Double?,
    @ColumnInfo(name = "vote_count")
    val voteCount: Int?
): BaseEntity()
