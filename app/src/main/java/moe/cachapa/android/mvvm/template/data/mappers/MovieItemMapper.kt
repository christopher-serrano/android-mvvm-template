package moe.cachapa.android.mvvm.template.data.mappers

import moe.cachapa.android.mvvm.template.data.db.entity.MovieItemEntity
import moe.cachapa.android.mvvm.template.data.model.MovieItem
import moe.cachapa.android.mvvm.template.utils.mappers.Mapper

class MovieItemMapper : Mapper<MovieItemEntity, MovieItem> {
    override fun map(input: MovieItemEntity): MovieItem = MovieItem(
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