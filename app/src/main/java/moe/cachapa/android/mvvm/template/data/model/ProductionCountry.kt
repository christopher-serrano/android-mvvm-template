package moe.cachapa.android.mvvm.template.data.model

import com.google.gson.annotations.SerializedName

data class ProductionCountry(
    @SerializedName("iso_3166_1")
    var iso31661: String?,
    @SerializedName("name")
    var name: String?
)
