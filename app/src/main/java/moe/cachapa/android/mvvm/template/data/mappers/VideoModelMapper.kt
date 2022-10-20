package moe.cachapa.android.mvvm.template.data.mappers

import moe.cachapa.android.mvvm.template.data.db.entity.VideoEntity
import moe.cachapa.android.mvvm.template.data.model.Video
import moe.cachapa.android.mvvm.template.utils.mappers.Mapper

class VideoModelMapper : Mapper<VideoEntity?, Video?> {
    override fun map(input: VideoEntity?): Video =
        Video(
            iso6391 = input?.iso6391,
            iso31661 = input?.iso31661,
            name = input?.name,
            key = input?.key,
            site = input?.site,
            size = input?.size,
            type = input?.type,
            official = input?.official,
            publishedAt = input?.publishedAt,
            id = input?.id
        )

}