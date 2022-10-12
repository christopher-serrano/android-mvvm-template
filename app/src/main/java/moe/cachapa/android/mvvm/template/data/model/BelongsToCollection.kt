package moe.cachapa.android.mvvm.template.data.model

import com.google.gson.annotations.SerializedName

data class BelongsToCollection(
        @SerializedName("id")
        var id: Int?,
        @SerializedName("name")
        var name: String?,
        @SerializedName("poster_path")
        var posterPath: String?,
        @SerializedName("backdrop_path")
        var backdropPath: String?
    )