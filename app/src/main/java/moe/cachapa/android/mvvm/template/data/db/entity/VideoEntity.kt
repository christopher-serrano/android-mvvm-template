package moe.cachapa.android.mvvm.template.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index

@Entity(
    tableName = "video_detail",
    indices = [Index(value = ["id"], unique = true)]
)
data class VideoEntity(
    @ColumnInfo(name = "iso_639_1")
    val iso6391: String?,
    @ColumnInfo(name = "iso_3166_1")
    val iso31661: String?,
    @ColumnInfo(name = "name")
    val name: String?,
    @ColumnInfo(name = "key")
    val key: String?,
    @ColumnInfo(name = "site")
    val site: String?,
    @ColumnInfo(name = "size")
    val size: Int?,
    @ColumnInfo(name = "type")
    val type: String?,
    @ColumnInfo(name = "official")
    val official: Boolean?,
    @ColumnInfo(name = "published_at")
    val publishedAt: String?,
    @ColumnInfo(name = "id")
    val id: String?
): BaseEntity()
