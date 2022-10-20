package moe.cachapa.android.mvvm.template.data.mappers

import moe.cachapa.android.mvvm.template.data.db.entity.MovieDetailEntity
import moe.cachapa.android.mvvm.template.data.model.MovieDetail
import moe.cachapa.android.mvvm.template.utils.mappers.Mapper

class MovieDetailMapper : Mapper<MovieDetailEntity, MovieDetail> {
    override fun map(input: MovieDetailEntity): MovieDetail =
        MovieDetail(
            adult = input.adult,
            backdropPath = input.backdropPath,
            belongsToCollection = input.belongsToCollection,
            budget = input.budget,
            genres = input.genres,
            homepage = input.homepage,
            id = input.id,
            imdbId = input.imdbId,
            originalLanguage = input.originalLanguage,
            originalTitle = input.originalTitle,
            overview = input.overview,
            popularity = input.popularity,
            posterPath = input.posterPath,
            productionCompanies = input.productionCompanies,
            productionCountries = input.productionCountries,
            releaseDate = input.releaseDate,
            revenue = input.revenue,
            runtime = input.runtime,
            spokenLanguages = input.spokenLanguages,
            status = input.status,
            tagline = input.tagline,
            title = input.title,
            video = input.video,
            voteAverage = input.voteAverage,
            voteCount = input.voteCount
        )
}