package moe.cachapa.android.mvvm.template.data.model.response

import com.google.gson.annotations.SerializedName
import moe.cachapa.android.mvvm.template.data.model.Video

data class VideoListResponse(
    @SerializedName("id")
    var id: Int?,
    @SerializedName("results")
    var results: List<Video>?
)
