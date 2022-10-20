package moe.cachapa.android.mvvm.template.data.mappers

import androidx.room.ColumnInfo
import moe.cachapa.android.mvvm.template.data.db.entity.MovieItemEntity
import moe.cachapa.android.mvvm.template.data.model.MovieItem
import moe.cachapa.android.mvvm.template.data.model.Video
import moe.cachapa.android.mvvm.template.utils.mappers.Mapper

class MovieItemEntityMapper : Mapper<MovieItem, MovieItemEntity> {
    override fun map(input: MovieItem): MovieItemEntity = MovieItemEntity(
        adult = input.adult,
        backdropPath = input.backdropPath,
        id = input.id,
        title = input.title,
        originalLanguage = input.originalLanguage,
        originalTitle = input.originalTitle,
        overview = input.overview,
        posterPath = input.posterPath,
        mediaType = input.mediaType,
        genreIds = input.genreIds,
        popularity = input.popularity,
        releaseDate = input.releaseDate,
        video = input.video,
        voteAverage = input.voteAverage,
        voteCount = input.voteCount
    )
}