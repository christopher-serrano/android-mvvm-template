package moe.cachapa.android.mvvm.template.data.model.response


import com.google.gson.annotations.SerializedName
import moe.cachapa.android.mvvm.template.data.model.Video

data class VideoListResponse(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("results")
    val results: List<Video?>?
)